package BinaryTrees;
import java.util.*;
public class IterativePostOrder {
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
    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.add(root);

            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
                if (stack2.peek().left != null)
                    stack1.push(stack2.peek().left);
                if (stack2.peek().right != null)
                    stack1.push(stack2.peek().right);
            }
            while (!stack2.isEmpty()) {
                ans.add(stack2.pop().val);
            }
            return ans;
        }
        //using 1 stack, hack way
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) return ans;
            Stack<TreeNode> stack1 = new Stack<>();
            stack1.add(root);

            while (!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                ans.add(temp.val);
                if (temp.left != null)
                    stack1.push(temp.left);
                if (temp.right != null)
                    stack1.push(temp.right);
            }
            Collections.reverse(ans);
            return ans;
        }
        //using one stack pro-way
        public List<Integer> postorderTraversal2(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode currentNode = root;
            TreeNode lastVisited = null;

            while (currentNode != null || !stack.isEmpty()) {
                if (currentNode != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;
                } else {
                    TreeNode peekNode = stack.peek();
                    if (peekNode.right != null && lastVisited != peekNode.right) {
                        currentNode = peekNode.right;
                    } else {
                        result.add(peekNode.val);
                        lastVisited = stack.pop();
                    }
                }
            }

            return result;
        }
    }
}
