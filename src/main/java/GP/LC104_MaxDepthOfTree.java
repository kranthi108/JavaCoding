package GP;

import java.util.Random;

public class LC104_MaxDepthOfTree {
    public static void main(String[] args) {
//        TreeNode head = null;
//        Random rand = new Random();

        // Creating 10 random values between 1 and 100
        TreeNode root = new TreeNode(1); // Random root value

        // Manually create the binary tree with 10 random elements
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//
//        root.left.left.left = new TreeNode(8);
//        root.left.left.right = new TreeNode(9);
//
//        root.left.right.left = new TreeNode(10);
//        root.right.left.left = new TreeNode(11);
        System.out.println(maxDepth(root));
//        TreeNode.printTree(root);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }
}
