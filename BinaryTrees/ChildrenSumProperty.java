package BinaryTrees;
//brute force
public class ChildrenSumProperty {
    static class Solution {
        public static int isSumProperty(TreeNode root) {
            if (root == null) return 1; // If the tree is empty, return true
            return traverseAndCheck(root);
        }

        static int traverseAndCheck(TreeNode root) {
            if (root == null) return 1;

            if (dfs(root, 0) != root.val) return 0;

            if (traverseAndCheck(root.left) == 0 || traverseAndCheck(root.right) == 0) return 0;
            return 1;
        }


        static long dfs(TreeNode root, long sum) {
            if (root == null) return sum;
            if (root.left == null && root.right == null)
                return sum + root.val;
            sum = dfs(root.left, sum);
            sum = dfs(root.right, sum);
            return sum;
        }
    }
}
