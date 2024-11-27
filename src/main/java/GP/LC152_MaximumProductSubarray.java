package GP;

public class LC152_MaximumProductSubarray {
    public static void main(String[] args) {
        int[] input = {2,3,-2,4};
        int max = input[0];
        int min = input[0];
        int result = input[0];
        for (int i=1; i<input.length; i++) {
            if(input[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(input[i], input[i]*max);
            min = Math.min(input[i], input[i]*min);
            result = Math.max(result, max);
        }
        System.out.println(result);
    }
}
