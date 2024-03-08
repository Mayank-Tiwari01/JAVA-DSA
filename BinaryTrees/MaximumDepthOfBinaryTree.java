package BinaryTrees;
//recursive
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
    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        return 1 + Math.max(maxLeft, maxRight);
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

        System.out.println(maxDepth(root));
    }
}
