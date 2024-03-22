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
            list.add(queue.peek().val);
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
        }
        return list;
    }
    //recursive
    static void leftViewRecursive(TreeNode node, int level, List<Integer> ans) {
        if (node == null) return;

        if (level == ans.size())
            ans.add(node.val);

        leftViewRecursive(node.left, level + 1, ans);
        leftViewRecursive(node.right, level + 1, ans);
    }
}