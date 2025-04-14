package GP;

public class LC2458_HeightOfBTafterDelete {
    int[] maxDepth1;
    int[] maxDepth2;
    int[] levArr;
    int[] depth;
    public int[] treeQueries(TreeNode root, int[] queries) {
        depth = new int[100001];
        levArr = new int[100001];
        maxDepth1 = new int[100001];
        maxDepth2 = new int[100001];
        height(root, 0);
        for(int i = 0; i < queries.length; i++) {
            int level = levArr[queries[i]];
            queries[i] = (maxDepth1[level] == depth[queries[i]] ? maxDepth2[level] : maxDepth1[level]) + level -1;
        }
        return queries;
    }
    public int height(TreeNode root, int level) {
        if(root == null)
            return 0;
        levArr[root.val] = level;
        depth[root.val] = 1 + Math.max(height(root.left, level+1), height(root.right, level+1));
        if(maxDepth1[level] < depth[root.val]) {
            maxDepth2[level] = maxDepth1[level];
            maxDepth1[level] = depth[root.val];
        }
        else if(maxDepth2[level] < depth[root.val])
            maxDepth2[level] = depth[root.val];
        return depth[root.val];
    }
    public static void main(String[] args) {
        LC2458_HeightOfBTafterDelete classObj = new LC2458_HeightOfBTafterDelete();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] queries = {3,5};
        classObj.treeQueries(root, queries);
    }

}
