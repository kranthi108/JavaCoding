package GP;

/**
 * Created by find the largest subsequence among the 3 strings
 * kranthi , aarathi, rathi
 * ans = thi
 */
public class DpWorld2 {
    public static void main(String[] args) {
        String s1 = "kaant";
        String s2 = "aranted";
        String s3 = "viranting";
        int maxTillNow = 0;
        int n = s1.length(), m = s2.length(), o = s3.length();
        int dp[][][] = new int[n+1][m+1][o+1];
        for(int i = 1; i<=n ; i++) {
            for( int j =1; j<=m; j++) {
                for(int k =1; k<=o; k++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1) && s2.charAt(j-1) ==s3.charAt(k-1)) {
                        dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                        maxTillNow = Math.max(maxTillNow, dp[i][j][k]);
                    }else {
                        dp[i][j][k] = 0;
                    }
                }
            }
        }
        System.out.println(maxTillNow);
    }
}







