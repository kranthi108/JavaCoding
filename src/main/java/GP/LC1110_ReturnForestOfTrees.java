package GP;

import java.util.*;

public class LC1110_ReturnForestOfTrees {
    HashSet<Integer> set = new HashSet<>();
    HashMap<Integer, TreeNode> result = new HashMap<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        Arrays.stream(to_delete).forEach(set::add);
        for(int a : to_delete)
            set.add(a);
        result.put(root.val, root);
        getForest(root, null, false);
        return new ArrayList<>(result.values());
    }
    void getForest(TreeNode currentNode, TreeNode parent, boolean isLeft) {
        if( currentNode==null) return;
        getForest(currentNode.left, currentNode, true);
        getForest(currentNode.right, currentNode, false);
        if(set.contains(currentNode.val)) {
            result.remove(currentNode.val);
            if(parent == null) {
                if(isLeft) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }
            if(currentNode.left != null)
                result.put(currentNode.left.val, currentNode.left);
            if(currentNode.right != null)
                result.put(currentNode.right.val, currentNode.right);
        }
    }

    public static void main(String[] args) {
        LC1110_ReturnForestOfTrees classObject = new LC1110_ReturnForestOfTrees();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] to_delete = {3,5};
        classObject.delNodes(root, to_delete);
    }
}
