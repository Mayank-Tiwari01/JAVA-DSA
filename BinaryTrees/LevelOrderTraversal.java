package BinaryTrees;
/*
Bhai ye kya hora bhai, ye kya hora.
https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeBuilder {
    private int index = 0;

    public TreeNode buildTreeFromArray(int[] values) {
        return buildTreeFromArray(values, values.length);
    }

    private TreeNode buildTreeFromArray(int[] values, int size) {
        if (index < size && values[index] != -1) {
            TreeNode root = new TreeNode(values[index]);
            index++;
            root.left = buildTreeFromArray(values, size);
            index++;
            root.right = buildTreeFromArray(values, size);
            return root;
        }
        return null;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return ans;

        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> levels = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                levels.add(queue.remove().val);
            }
            ans.add(levels);
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();

        // Example array representing the tree: [3, 9, 20, -1, -1, 15, 7]
        int[] values = {3, 9, 20, -1, -1, 15, 7};

        // Build the tree
        TreeNode root = builder.buildTreeFromArray(values);

        // Create an instance of Solution
        Solution solution = new Solution();

        // Call the levelOrder method and print the result
        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result);
    }
}
