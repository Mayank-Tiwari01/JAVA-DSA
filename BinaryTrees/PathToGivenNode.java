package BinaryTrees;
//https://www.interviewbit.com/problems/path-to-given-node/
import java.util.ArrayList;
public class PathToGivenNode {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> list = new ArrayList<>();
        if (A == null) return list;
        helper(A, B, list);

        return list;
    }
    static boolean helper(TreeNode root, int n, ArrayList<Integer> list) {
        if (root == null) return false;
        list.add(root.val);

        if (root.val == n) return true;
        if (helper(root.left, n, list) || helper(root.right, n, list)) return true;

        list.remove(list.size() - 1);
        return false;
    }
}
