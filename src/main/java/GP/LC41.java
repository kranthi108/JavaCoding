package GP;

public class LC41 {
    public static void main(String[] args) {
        int[] inpt = {1,2,5,8,5,3};
        int firstMissingInteger = firstMissingPositive(inpt);
        System.out.println(firstMissingInteger);
    }
    public static int firstMissingPositive(int[] nums) {
        // Iterate and change numbers which are greaterthan length
        for(int i =0;i<nums.length; i++) {
            if(nums[i] <=0 || nums[i] > nums.length)
                nums[i] = nums.length+2;
        }
        // change number's index to negative
        for(int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i]);
            if(num <= nums.length) {
                nums[num-1] = -1*Math.abs(nums[num-1]);
            }
        }
        //return first positive
        for(int i=0;i<nums.length;i++) {
            if(nums[i] > 0)
                return i+1;
        }
        return nums.length+1;
    }
}
