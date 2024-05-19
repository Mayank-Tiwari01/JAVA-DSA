package BinaryTrees;

public class DistributeCoinsInBinaryTree {
    static class Solution {
        public int distributeCoins(TreeNode root) {
            int[] moves = new int[1];
            helper(root, moves);
            return moves[0];
        }
        static int helper(TreeNode root, int[] moves) {
            if (root == null) return 0;

            int left = helper(root.left, moves);
            int right = helper(root.right, moves);

            moves[0] += Math.abs(left + right + root.val - 1);

            return left + right + root.val - 1;
        }
    }
}
