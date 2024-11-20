package GP;

public class LC55_JumpGame {
    public static void main(String[] args) {
        int[] jumpArray = {3,2,1,0,4};
        if(canJump(jumpArray))
            System.out.println("Yes reaching end is possible");
        else System.out.println("No, Its not possible to reach end");
    }
    public static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest)
                return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1)
                return true;
        }
        return false;
    }
}
