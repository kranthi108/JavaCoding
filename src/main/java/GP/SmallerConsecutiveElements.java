package GP;
import java.util.Arrays;
import java.util.Stack;

public class SmallerConsecutiveElements {
    public static int[] countSmallerConsecutiveElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[i] = Math.max(result[i], result[stack.pop()] + 1);
            }
            if (!stack.isEmpty()) {
                result[i] = Math.max(result[i], arr[stack.peek()] < arr[i] ? 1 : 0);
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = {4, 3, 5, 1, 6, 7, 2, 3};
        int[] output = countSmallerConsecutiveElements(input);
//        System.out.println("GKDFKDKF");
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Output: " + Arrays.toString(output));
    }
}