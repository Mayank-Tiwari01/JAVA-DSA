package BinaryTrees;
import java.util.*;
public class SymmetricTree {
    public static void main(String[] args) {
        class Solution {
            public boolean isSymmetricDFS(TreeNode root) {
                if (root == null) return true;
                return helper(root.left, root.right);
            }

            static boolean helper(TreeNode p, TreeNode q) {
                if (p == null && q == null) return true;
                if (p == null || q == null) return false;
                if (p.val != q.val) return false;

                return helper(p.left, q.right) && helper(p.right, q.left);
            }
            public boolean isSymmetricBFS(TreeNode root) {
                if (root == null) return true;

                Queue<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                queue.add(root); // Enqueue root twice to represent the mirror pairs

                while (!queue.isEmpty()) {
                    TreeNode leftNode = queue.poll();
                    TreeNode rightNode = queue.poll();

                    // If both nodes are null, continue to the next pair
                    if (leftNode == null && rightNode == null) continue;

                    // If only one node is null, or their values are different, return false
                    if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;

                    // Enqueue their children in opposite order
                    queue.add(leftNode.left);
                    queue.add(rightNode.right);
                    queue.add(leftNode.right);
                    queue.add(rightNode.left);
                }

                // If the entire tree has been processed without encountering asymmetry, return true
                return true;
            }
        }
    }
}
