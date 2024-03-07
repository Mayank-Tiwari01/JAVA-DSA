package BinaryTrees;
import java.util.*;
public class ItervativeInOrder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    static class SolutionInorderIterative {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Stack<TreeNode> stack = new Stack<>();
            while (true) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                else {
                    if (stack.isEmpty()) break;
                    root = stack.pop();
                    ans.add(root.val);
                    root = root.right;
                }
            }
            return ans;
        }
    }
}
