package GP;

public class LC154_MinimumInRSA2 {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,4};
        int left = 0, right = nums.length-1;
        while(left<right) {
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]) {
                left = mid +1;
            }
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                right--;
            }
        }
        System.out.println(nums[left]);
    }
}
