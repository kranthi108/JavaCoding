package GP;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.lang.*;
class CommonCharInAllStrings {

    static int MAX_CHAR = 26;
    public static void commonCharacters1(@NotNull String str[], int n) {
        Boolean[] primary = new Boolean[MAX_CHAR];
        Arrays.fill(primary, new Boolean(true));
        for (int i=0; i<n; i++) {
            Boolean[] secondary = new Boolean[MAX_CHAR];
            Arrays.fill(secondary, new Boolean(false));
            for(int j=0; j<str[i].length(); j++) {
                if(primary[str[i].charAt(j) - 'a']) {
                    secondary[str[i].charAt(j) - 'a'] = true;
                }
            }
            System.arraycopy(secondary, 0, primary, 0, MAX_CHAR);
        }
        for(int i=0; i<MAX_CHAR; i++) {
//            System.out.println("dfsdkfaerka");
            if (primary[i]) {
                System.out.print(Character.toChars(i + 97));
            }
        }

    }

    // Driver code
    public static void main(String[] args)
    {
        String str[] = { "geeksforgeeks",
                "gemkstones",
                "acknowledges",
                "aguelikes" };

        int n = str.length;
        commonCharacters1(str, n);
    }
}
