package BinaryTrees;

public class SubtreeOfAnotherTree {
    class Solution {
        //Brute force. Not really, pretty optimal.
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            // Base case: If either of the trees is null, return false
            if (root == null || subRoot == null) {
                return false;
            }
            // Check if the current subtree is equal to the given subRoot
            if (isSameTree(root, subRoot)) {
                return true;
            }
            // Recursively check if the subRoot exists in the left or right subtree
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode p, TreeNode q) {
            // Base case: If both trees are null, they are considered equal
            if (p == null && q == null) {
                return true;
            }

            // Base case: If only one of the trees is null, they are not equal, both would not be null because
            // we have already checked it.
            if (p == null || q == null) {
                return false;
            }

            // Check if the current nodes have the same value
            if (p.val != q.val) {
                return false;
            }

            // Recursively check if the left and right subtrees are equal
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
