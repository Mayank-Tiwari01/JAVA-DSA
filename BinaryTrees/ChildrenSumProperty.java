package BinaryTrees;
//Very weird thing happening, this question is not on leetcode, so I obviously had to go to subpar platforms like gfg
//and coding ninjas. Now some test cases are failing on these platforms, but when I run on leetcode, the output is
//correct. So yeah.
public class ChildrenSumProperty {
    public static boolean isParentSum(TreeNode root) {
        if (root == null) return false;
        int rootVal = root.val;
        if (root.left == null && root.right == null) return true;

        long leafSum = dfs(root);
        return leafSum == rootVal;
    }

    static long dfs(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return root.val;

        long leftSum = dfs(root.left);
        long rightSum = dfs(root.right);

        return leftSum + rightSum;
    }
}