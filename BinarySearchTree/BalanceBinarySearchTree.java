package BinarySearchTree;
import java.util.List;
import java.util.ArrayList;
public class BalanceBinarySearchTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
          this.left = left;
         this.right = right;
     }
  }
    static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> sorted = new ArrayList<>();
        inorder(root, sorted);
        return helper(sorted, 0, sorted.size() - 1);
    }
    static void inorder(TreeNode root, List<TreeNode> ans) {
        if (root == null) return;

        inorder(root.left, ans);
        ans.add(root);
        inorder(root.right, ans);
    }
    static TreeNode helper(List<TreeNode> list, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;

        TreeNode ans = new TreeNode();
        ans = list.get(mid);

        ans.left = helper(list, start, mid - 1);
        ans.right = helper(list, mid + 1, end);

        return ans;
    }
}
