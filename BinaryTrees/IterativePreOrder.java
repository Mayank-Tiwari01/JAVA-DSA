package BinaryTrees;
import java.util.*;
//https://leetcode.com/problems/binary-tree-preorder-traversal/
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
class solutionPreIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preOrder = new ArrayList<>();
        if (root == null)
            return preOrder;

        stack.add(root);
        while (!stack.isEmpty()) {
            int len = stack.size();
            for (int i = 0; i < len; i++) {
                TreeNode peek = stack.pop();
                if (peek.right != null)
                    stack.add(peek.right);

                if (peek.left != null)
                    stack.add(peek.left);

                preOrder.add(peek.val);
            }
        }
        return preOrder;
    }
}