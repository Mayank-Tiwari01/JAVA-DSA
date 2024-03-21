package BinaryTrees;
import java.util.*;
public class VerticalWidthOfBinaryTree {
    public static int verticalWidth(TreeNode root)
    {
        Set<Integer> set = new HashSet<>();
        helper(root, 0, set);
        return set.size();
    }
    static void helper(TreeNode root, int dis, Set<Integer> set) {
        if (root == null) return;

        helper(root.left, dis - 1, set);
        set.add(dis);
        helper(root.right, dis + 1, set);
    }
}
