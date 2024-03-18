package BinaryTrees;
import java.util.*;
/*
Can be solved in three steps.
1: Add the left boundary, except the leaf nodes. Also keep in mind to traverse the left subtree only, traverse the
right part only where there does not exist a left subtree.

2: Add the leaf nodes, use any dfs traversal, do not use bfs.
3: Add the right subtree, but in reverse order, use a stack for this, also only traverse the right subtree, traverse the
left subtree if any node does not have a right subtree.
 */
public class BoundaryTraversalOfBinaryTree {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }

    static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        if (root == null) return ans;

        ans.add(root.data);
        if (root.left != null)
            addLeftBoundary(root.left, ans);

        addLeafElements(root, ans);
        if (root.right != null) {
            addRightBoundary(root.right, stack);
            while (!stack.isEmpty()) ans.add(stack.pop());
        }
        return ans;
    }
    static void addLeftBoundary(TreeNode root, List<Integer> ans) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            ans.add(root.data);
            if (root.left != null)
                addLeftBoundary(root.left, ans);
            if (root.left == null && root.right != null)
                addLeftBoundary(root.right, ans);
        }
    }
    static void addLeafElements(TreeNode root, List<Integer> ans) {
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }
        if (root.left != null)
            addLeafElements(root.left, ans);
        if (root.right != null)
            addLeafElements(root.right, ans);
    }
    static void addRightBoundary(TreeNode root, Stack<Integer> ans) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            ans.add(root.data);
            if (root.right != null)
                addRightBoundary(root.right, ans);
            if (root.right == null && root.left != null)
                addRightBoundary(root.left, ans);
        }
    }
}