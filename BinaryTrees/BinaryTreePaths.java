package BinaryTrees;
import java.util.ArrayList;
import java.util.List;
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        helper(list, new StringBuilder(), root);
        return list;
    }
    static void helper(List<String> list, StringBuilder str, TreeNode root) {
        if (root == null) {
            return;
        }

        int length = str.length();
        if (length > 0) {
            str.append("->"); //meh
        }
        str.append(root.val);

        if (root.left == null && root.right == null) {
            list.add(str.toString());
        } else {
            helper(list, new StringBuilder(str), root.left);
            helper(list, new StringBuilder(str), root.right);
        }
        str.setLength(length);
    }
}