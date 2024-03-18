package BinaryTrees;
import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }
    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                if (level % 2 != 0)
                    ds.add(0, temp.val); //adding from the end.
                else
                    ds.add(temp.val);
            }
            ans.add(ds);
            level++;
        }
        return ans;
    }
}
