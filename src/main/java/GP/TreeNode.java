package GP;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);  // Visit left subtree
            System.out.print(root.val + " ");  // Print node value
            printTree(root.right); // Visit right subtree
        }
    }
}
