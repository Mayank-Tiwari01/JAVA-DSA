package BinaryTrees;
import java.util.*;
//gfg
public class AllRootToLeafPathsInBinaryTree {
    public static ArrayList<ArrayList<Integer>> Paths(TreeNode root) {
        // code here
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;

        ArrayList<Integer> path = new ArrayList<>();
        helper(paths, path, root);

        return paths;
    }
    static void helper (ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            path.add(root.val);
            paths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        }
        path.add(root.val);
        helper(paths, path, root.left);
        helper(paths, path, root.right);
        path.remove(path.size() - 1);
    }
}

