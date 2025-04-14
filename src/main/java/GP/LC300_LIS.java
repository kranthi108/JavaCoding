package GP;

import java.util.Arrays;

public class LC300_LIS {
    public static void main(String[] args) {
        LC300_LIS lis = new LC300_LIS();
        System.out.println(lis.lengthOfLISRecursive(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21}));
    }
    public int lengthOfLISRecursive(int[] nums) {
        return lisUtil(nums, 0, Integer.MIN_VALUE);
    }
    int lisUtil(int[] nums, int index, int prev) {
        if (index == nums.length)
            return 0;
        int exclude = lisUtil(nums, index+1, prev);
        int include = 0;
        if (nums[index] > prev){
            include = 1 + lisUtil(nums, index+1, nums[index]);
        }
        return Math.max(include, exclude);
    }
    public int lengthOfLIS(int[] num) {
        int[] dp = new int[num.length];
        int lis = 1;
        int max = 1;
        Arrays.fill(dp, 1);
        for(int i=0; i<num.length; i++) {
            for(int j = 0; j < i; j++) {
                if(num[j] < num[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public int lengthOfLis(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}
