package GP;

public class LC26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 2, 3, 4, 5, 5, 5, 5, 6, 7, 7,};
        int result = removeDuplicates(array);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i - 1]) {
                continue;
            }
            else {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
