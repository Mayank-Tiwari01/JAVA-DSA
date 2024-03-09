package BinaryTrees;
import java.util.Stack;
public class BalancedBinaryTreeBruteForce {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    //iterative in-order dfs.
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                if (stack.isEmpty()) break;
                root = stack.pop();
                int leftSubTree = findHeight(root.left);
                int rightSubtree = findHeight(root.right);
                if (Math.abs(leftSubTree - rightSubtree) > 1)
                    return false;
                root = root.right;
            }
        }
        return true;
    }
    //recursive dfs
    static boolean isBalancedRec(TreeNode root) {
        if (root == null) return true;

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalancedRec(root.left) && isBalancedRec(root.right);
    }
    //simple recursive dfs to find height
    static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1 + Math.max(left, right);
    }
}
