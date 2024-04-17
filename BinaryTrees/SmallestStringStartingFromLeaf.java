package BinaryTrees;
import java.util.ArrayList;
public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {
    }
    private String smallestFromLeaf(TreeNode root) {
        if (root == null) return "";
        helper (root, new StringBuilder());
        return ans;
    }
    private String ans = "";
    private void helper (TreeNode root, StringBuilder str) {
        if (root.left == null && root.right == null) {
            str.insert(0, (char) (97 + root.val));
            StringBuilder temp = new StringBuilder(str);
            if (ans.equals("") || temp.toString().compareTo(ans) < 0)
                ans = temp.toString();
            return;
        }
        int len = str.length();
        str.insert(0, (char) (97 + root.val));

        if (root.left != null)
            helper(root.left, new StringBuilder(str));
        if (root.right != null)
            helper(root.right, new StringBuilder(str));
        str.setLength(len);
    }
    private void helperSort (TreeNode root, ArrayList<String> list, StringBuilder str) {
        //sort the list and return the first string.
        if (root.left == null && root.right == null) {
            str.insert(0, (char) (97 + root.val));
            list.add(String.valueOf(str));
            return;
        }
        int len = str.length();
        str.insert(0, (char) (97 + root.val));

        if (root.left != null)
            helperSort (root.left, list, new StringBuilder(str));
        if (root.right != null)
            helperSort (root.right, list, new StringBuilder(str));
        str.setLength(len);
    }
}
