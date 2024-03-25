package BinaryTrees;
import java.util.*;
/*
The main hint is left child index = 2 * n. Right = 2 * n + 1.
 */
public class MaximumWidthOfBinaryTree {
    //Optimal, use of long is essential because we are doing 2 * n everytime, so it will overflow.
    static class Pair {
        TreeNode node;
        long idx;

        Pair (TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        long maxWidth = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;

            for (int i = 0; i < len; i++) {
                Pair temp = queue.poll();
                TreeNode node = temp.node;
                long idx = temp.idx;

                if (node.left != null)
                    queue.offer(new Pair(node.left, 2 * idx));
                if (node.right != null)
                    queue.offer(new Pair(node.right, 2 * idx + 1));

                min = Math.min(min, idx);
                max = Math.max(max, idx);
            }
            maxWidth = Math.max(maxWidth, max - min + 1);
        }
        return (int) maxWidth;
    }
    //OG approach but will give MLE.
    static int index = 0;
    public int widthOfBinaryTree1(TreeNode root) {
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
