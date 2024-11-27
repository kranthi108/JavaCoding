package GP;

import java.util.Arrays;
import java.util.Map;

public class LC300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] num = {10,9,2,5,3,7,101,18};
        int[] dp = new int[num.length];
        int lis = 1;
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=0; i<num.length; i++) {
            for(int j = 0; j < i; j++) {
                if(num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = max>dp[i] ? max : dp[i];
                }
            }
        }
        System.out.println(max);
    }
}
