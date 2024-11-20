package GP;

public class LC45_JumpGame2 {
    public static void main(String[] args) {
        int[] jumpArray = {2,3,0,1,4};
        System.out.println("minimum step required for reaching end is " + jump(jumpArray));
    }
    public static int jump(int[] nums) {
        int jumps = 0, currEnd = 0, currFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currFarthest = Math.max(currFarthest, i + nums[i]);
            if (i == currEnd) {
                jumps++;
                currEnd = currFarthest;
            }
        }
        return jumps;
    }
}
