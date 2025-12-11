package GP;


import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.util.Stack;

public class OracleTech2 {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(int[] pt) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        for(int element : pt) {
            if(element < root) { // 4
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < element) { // 4,6,1,3,2,5,7
                root = stack.pop();
            }
            stack.push(element); //{  3}
        }
        return  true;
    }
}
//


//4 is root
// given integer array positive and distinct . check whether its a preorder traversal of a bst

//   4,2,1,3,6,5,7
