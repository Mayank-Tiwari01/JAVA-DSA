package BinaryTrees;
import java.util.*;
/*
OG approach but will give MLE.
 */
public class MaximumWidthOfBinaryTree {
    static int index = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode newNode = new TreeNode(-101);//will be used to identify null value.
        int maxWidth = 0;

        while (true) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            boolean lastLevel = true;
            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    queue.add(temp.left);
                    lastLevel = false;
                }
                if (temp.left == null)
                    queue.add(newNode);
                if (temp.right != null) {
                    queue.add(temp.right);
                    lastLevel = false;
                }
                if (temp.right == null)
                    queue.add(newNode);

                list.add(temp.val);
            }
            maxWidth = Math.max(maxWidth, findWidth(list));
            if (lastLevel) break;
        }
        return maxWidth;
    }
    static int findWidth(List<Integer> list) {
        int i = 0, j = list.size() - 1;

        while (i < j) {
            if (list.get(i) == -101)
                i++;
            if (list.get(j) == -101)
                j--;
            if (list.get(i) != -101 && list.get(j) != -101)
                break;
        }
        return j - i + 1;
    }
    public static TreeNode createBinaryTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        index = 1;
        while (!queue.isEmpty() && index < arr.length) {
            TreeNode node = queue.poll();

            if (arr[index] != null) {
                node.left = new TreeNode(arr[index]);
                queue.offer(node.left);
            }

            index++;

            if (index < arr.length && arr[index] != null) {
                node.right = new TreeNode(arr[index]);
                queue.offer(node.right);
            }

            index++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, null, 5 ,6, null, 7, null, null, null, null, null, null};
        TreeNode root = MaximumWidthOfBinaryTree.createBinaryTree(arr);

        MaximumWidthOfBinaryTree solution = new MaximumWidthOfBinaryTree();
        int maxWidth = solution.widthOfBinaryTree(root);
        System.out.println("Maximum Width: " + maxWidth);
    }
}
