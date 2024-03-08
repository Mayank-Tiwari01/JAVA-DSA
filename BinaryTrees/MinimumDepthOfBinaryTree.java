package BinaryTrees;

import java.util.*;
//OOPS padhna pdega acche se.
/*
The DFS approach will always traverse all the nodes of the binary tree,
regardless of the tree structure.
The BFS approach has the potential
to terminate early if the minimum depth leaf node is encountered before traversing all the nodes,
but in the worst case, it will still traverse all the nodes.
 */
public class MinimumDepthOfBinaryTree {
    class TreeNode {
        int val;
        MinimumDepthOfBinaryTree.TreeNode left;
        MinimumDepthOfBinaryTree.TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, MinimumDepthOfBinaryTree.TreeNode left, MinimumDepthOfBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //bfs
    static int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minD = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode peek = queue.remove();
                if (peek.left == null && peek.right == null)
                    return minD;
                if (peek.left != null)
                    queue.add(peek.left);
                if (peek.right != null)
                    queue.add(peek.right);
            }
            minD++;
        }
        return minD;
    }
    //dfs
    static int minDepthDFS(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int minL = (root.left != null) ? minDepthDFS(root.left) : Integer.MAX_VALUE;
        int minR = (root.right != null) ? minDepthDFS(root.right): Integer.MAX_VALUE;

        return 1 + Math.min(minL, minR);
    }

    public static void main(String[] args) {
        MinimumDepthOfBinaryTree solution = new MinimumDepthOfBinaryTree();
        MinimumDepthOfBinaryTree.TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.left.left = solution.new TreeNode(6);
        root.left.right = solution.new TreeNode(7);
        root.right = solution.new TreeNode(3);
        root.right.left = solution.new TreeNode(4);
        root.right.right = solution.new TreeNode(5);

        Queue<MinimumDepthOfBinaryTree.TreeNode> queue = new LinkedList<>();

        System.out.println(minDepth(root));
    }
}


