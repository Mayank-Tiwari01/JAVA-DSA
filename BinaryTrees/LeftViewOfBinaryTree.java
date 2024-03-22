package BinaryTrees;
//gfg
import java.util.*;
public class LeftViewOfBinaryTree {
    static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            int leftMost = -1;
            boolean found = false;
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                if (!found) {
                    leftMost = temp.val;
                    found = true;
                }

            }
            list.add(leftMost);
        }
        return list;
    }
}