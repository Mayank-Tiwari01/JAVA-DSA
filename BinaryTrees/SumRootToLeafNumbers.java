package BinaryTrees;
import java.util.*;
public class SumRootToLeafNumbers {
    public static void main(String[] args) {

    }
    static int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> nums = new ArrayList<>();
        helper(root, nums, new StringBuilder());
        long sum = 0;
        for (String str : nums) {
            sum += Long.parseLong(str);
        }
        return (int) sum;
    }
    static void helper (TreeNode root, List<String> paths, StringBuilder pathSoFar) {
        pathSoFar.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(pathSoFar.toString());
            return;
        }
        if (root.left != null) {
            helper(root.left, paths, new StringBuilder(pathSoFar));
        }
        if (root.right != null) {
            helper(root.right, paths, new StringBuilder(pathSoFar));
        }
    }
    static void helperBackTracking (TreeNode root, List<String> paths, StringBuilder pathSoFar) {
        pathSoFar.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(pathSoFar.toString());
            return;
        }
        if (root.left != null) {
            helperBackTracking(root.left, paths, new StringBuilder(pathSoFar));
        }
        if (root.right != null) {
            helperBackTracking(root.right, paths, new StringBuilder(pathSoFar));
        }
    }
}
