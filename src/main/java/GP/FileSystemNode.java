package GP;

import java.io.File;

//main --
//        a -> a1& a2
//        b -> b1 & b2 (abc.txt)
//        File f = new File("/main");
//        File [] childfiles = f.listFiles();
//        f.isFile() - > true / false
//        f.delete()
public class FileSystemNode {

    public static void main(String[] args) {
//        File f = new File("/main");
        String rootpath = "/Users/kranthiramireddy/Desktop/main";
        File f = new File(rootpath);
//        boolean madeChange;
//        do {
//            madeChange = deleteEmptyFolders(f);
//        } while(madeChange);
        deleteEmptyFolders(f);
    }

    static boolean deleteEmptyFolders(File folder) {
        if(folder.isFile()) {
            return false;
        }
        boolean madeChanges = false;
        File[] childfiles = folder.listFiles();
        if(childfiles != null && childfiles.length == 0 ) {
            madeChanges = folder.delete();
        }
        else {
            for(File child : childfiles) {
                madeChanges |= deleteEmptyFolders(child);
            }
            if(madeChanges && folder.list().length == 0) {
                madeChanges = folder.delete();
            }
        }
        return madeChanges;
    }

//    static boolean deleteEmptyFolders(File folder) {
//        if(folder.isFile()) {
//            return false;
//        }
//        boolean madeChanges = false;
//        File[] childfiles = folder.listFiles();
//        if(childfiles != null && childfiles.length>0 ) {
//            for(File child : childfiles) {
//                boolean childDeleted = deleteEmptyFolders(child);
//                if(childDeleted) {
//                    madeChanges = true;
//                }
//            }
//            childfiles = folder.listFiles();
//        }
//        if(childfiles == null || childfiles.length == 0) {
//            folder.delete();
//            return true;
//        }
//        return madeChanges;
//    }
static boolean deleteEmptyFolderss(File folder) {
    // If it's a file, we don't delete it
    if (!folder.isDirectory()) {
        return false;
    }

    boolean madeChanges = false;
    File[] childFiles = folder.listFiles();

    // Process all children first
    if (childFiles != null) {
        for (File child : childFiles) {
            if (child.isDirectory()) {
                boolean childDeleted = deleteEmptyFolders(child);
                if (childDeleted) {
                    madeChanges = true;
                }
            }
        }
        // Get updated list after potential deletions
        childFiles = folder.listFiles();
    }

    // If this folder is now empty, delete it
    if (childFiles != null && childFiles.length == 0) {
        System.out.println("Deleting empty folder: " + folder.getAbsolutePath());
        if (folder.delete()) {
            return true;
        }
        else return false;
    }

    return madeChanges;
}
}
