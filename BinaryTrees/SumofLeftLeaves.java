package BinaryTrees;
import java.util.*;
public class SumofLeftLeaves {
    public static void main(String[] args) {

    }
    static int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;

        if (root.left != null) {
            if (root.left.left == null && root.left.right == null)
                ans += root.left.val;
            else
                ans += sumOfLeftLeaves(root.left);
        }
        ans += sumOfLeftLeaves(root.right);

        return ans;
    }
    static int sumOfLeftLeavesBFS(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null)
                    queue.offer(temp.left); // Corrected: offer temp.left, not root.left
                if (temp.right != null)
                    queue.offer(temp.right); // Corrected: offer temp.right, not root.right
                if (temp.left != null && temp.left.left == null && temp.left.right == null) {
                    sum += temp.left.val; // Moved inside the if condition
                }
            }
        }
        return sum;
    }
}
