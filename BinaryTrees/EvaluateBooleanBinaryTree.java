package BinaryTrees;

public class EvaluateBooleanBinaryTree {
    static class Solution {
        public boolean evaluateTree(TreeNode root) {
            // if (root == null) return false;
            if (root.left == null && root.right == null) {
                if (root.val == 0) return false;
                else if (root.val == 1) return true;
            }

            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);

            if (root.val == 2) return (left || right);
            return (left && right);
        }
    }
}
