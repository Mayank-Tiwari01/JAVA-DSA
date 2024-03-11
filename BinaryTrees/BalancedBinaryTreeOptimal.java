package BinaryTrees;

public class BalancedBinaryTreeOptimal {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static  boolean isBalanced(TreeNode root) {
        return findHeight(root) != -1;
    }

    static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        if (left == -1 || right == -1)
            return -1;
        if (Math.abs(left - right) > 1)
            return -1;
        return 1 + Math.max(left, right);
    }
}
