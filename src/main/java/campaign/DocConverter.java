package campaign;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class DocConverter {

    private static final String APPLICATION_NAME = "Google Drive Doc to PDF Converter";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     */
    private static Credential authorize() throws Exception {
        InputStream in = DocConverter.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    /**
     * Main logic to convert files.
     */
    public static void main(String... args) throws Exception {
        // --- CONFIGURATION ---
        final String SOURCE_FOLDER_ID = "1ORhSut5e5HWWbz8x_TRFtrHtRVmWezAa";
        final String DESTINATION_FOLDER_ID = "1MhH-4Qx5JF8ycNqrHUNhq6KZbqkOANrH";
        // --- END OF CONFIGURATION ---

        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, authorize())
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Query to find all Google Docs in the source folder
        String query = "'" + SOURCE_FOLDER_ID + "' in parents and mimeType='application/vnd.google-apps.document'";

        System.out.println("Finding Google Docs in source folder...");

        FileList result = service.files().list()
                .setQ(query)
                .setFields("files(id, name)")
                .execute();
        List<File> files = result.getFiles();

        if (files == null || files.isEmpty()) {
            System.out.println("No Google Docs found in the source folder.");
            return;
        }

        System.out.println("Found " + files.size() + " files to convert. Starting process...");

        int  i =0;
        for (File file : files) {
            i++;
            if(i<100) {

                continue;
            }

            System.out.println("Converting file: " + file.getName());

            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                // Export the Google Doc as a PDF
                service.files().export(file.getId(), "application/pdf")
                        .executeMediaAndDownloadTo(outputStream);

                // Create the new PDF file metadata
                File pdfMetadata = new File();
                pdfMetadata.setName(file.getName() + ".pdf");
                pdfMetadata.setParents(Collections.singletonList(DESTINATION_FOLDER_ID));

                // Create an InputStream from the downloaded bytes
                InputStream pdfInputStream = new ByteArrayInputStream(outputStream.toByteArray());

                // Create the new file in Google Drive
                service.files().create(pdfMetadata, new com.google.api.client.http.InputStreamContent("application/pdf", pdfInputStream))
                        .setFields("id")
                        .execute();

                System.out.println(" -> Successfully created PDF for: " + file.getName());
            } catch (IOException e) {
                System.err.println("An error occurred while converting " + file.getName() + ": " + e.getMessage());
            }
        }
        System.out.println("All files have been converted successfully!");
    }
}