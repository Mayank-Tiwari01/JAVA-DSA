package BinaryTrees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        return dfs (root, 0, targetSum);
    }
    static boolean dfs (TreeNode root, int sum, int reqSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            sum += root.val;
            if (sum == reqSum) return true;
        }
        return dfs (root.left, sum + root.val, reqSum) ||
                dfs(root.right, sum + root.val, reqSum);
    }
}