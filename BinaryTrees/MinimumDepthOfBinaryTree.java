package BinaryTrees;

import java.util.*;
//oops padhna pdega acche se.
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


