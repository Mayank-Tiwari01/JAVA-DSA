package BinaryTrees;

public class MaximumPathSumBT {
    public static void main(String[] args) {
        class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int value) {
                this.val = value;
                this.left = null;
                this.right = null;
            }
        }

    }
    static int helper(TreeNode root, int[] maxSum) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left, maxSum)); //if the left subtree is giving a -ve value,
        // Then that is useless in finding the max sum.
        // Same with right subtree.
        int right = Math.max(0, helper(root.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], left + right + root.val);

        return root.val + Math.max(left, right);
    }
}