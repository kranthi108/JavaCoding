package GP;

import java.util.concurrent.Executors;

public class LC169_MajorityElement {
    public static void main(String[] args) {
        int input[] = {2,2,1,1,1,1,2,2};
        // Wait for the thread to finish
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] nums)  {
        int result = nums[0];
        int frequency = 1;


        for( int i=1; i<nums.length; i++) {
            if(nums[i] == result)
                frequency++;
            else {
                if (frequency <= 1) {
                    frequency = 1;
                    result = nums[i];
                }
                else {
                    frequency--;
                }
            }
        }
        return result;
    }
}
