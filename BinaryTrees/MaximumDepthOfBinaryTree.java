package BinaryTrees;
import java.util.*;
//recursive and bfs both. bfs is og.
public class MaximumDepthOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //dfs(recursive)
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return 1 + Math.max(maxLeft, maxRight);
    }
    static int maxDepthBFS(TreeNode root) {
        //no need to make it so complicated though, just increment the maxDepth everytime you encounter a new level.
        //see lc for that code.
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxD = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            boolean nextLevel = false;
            for (int i = 0; i < len; i++) {
                TreeNode peek = queue.remove();
                if (peek.left != null) {
                    queue.add(peek.left);
                    maxD = (!nextLevel) ? maxD + 1 : maxD;
                    nextLevel = true;
                }
                if (peek.right != null) {
                    queue.add(peek.right);
                    maxD = (!nextLevel) ? maxD + 1 : maxD;
                    nextLevel = true;
                }
            }
        }
        return maxD;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
        MaximumDepthOfBinaryTree.TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.left.left = solution.new TreeNode(6);
        root.left.right = solution.new TreeNode(7);
        root.right = solution.new TreeNode(3);
        root.right.left = solution.new TreeNode(4);
        root.right.right = solution.new TreeNode(5);

        Queue<TreeNode> queue = new LinkedList<>();

        System.out.println(maxDepth(root));
    }

}
