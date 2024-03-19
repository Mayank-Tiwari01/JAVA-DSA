package BinaryTrees;
import java.util.*;
public class BinaryTreeRightSideView {
    class solution {
        //easiest bfs, also OG
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> arr = new ArrayList<>();

                for (int i = 0; i < len; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);

                    arr.add(temp.val);
                }
                list.add(arr.get(arr.size() - 1));
            }
            return list;
        }
        //same code as above, just with added weirdness, it was my OG thought, so I had to implement it.
        public List<Integer> rightSideView1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            if (root == null) return list;

            int rightHeight = rightTraversal(root, list);

            if (root.left != null)
                leftTraversal(root.left, list, rightHeight);
            return list;
        }

        private int rightTraversal(TreeNode root, List<Integer> list) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int height = 0;
            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> arr = new ArrayList<>();

                for (int i = 0; i < len; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);

                    arr.add(temp.val);
                }
                height++;
                list.add(arr.get(arr.size() - 1));
            }
            return height;
        }

        private void leftTraversal(TreeNode root, List<Integer> list, int rightHeight) {
            Queue<TreeNode> queue = new LinkedList<>();
            int leftLevel = 0;
            queue.add(root);

            while (!queue.isEmpty()) {
                int len = queue.size();
                List<Integer> arr = new ArrayList<>();

                for (int i = 0; i < len; i++) {
                    TreeNode temp = queue.poll();
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);

                    arr.add(temp.val);
                }
                leftLevel++;
                if (leftLevel >= rightHeight)
                    list.add(arr.get(arr.size() - 1));
            }
        }
        //recursive by claude
        public List<Integer> rightSideView2(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            rightTraversal(root, list, 0);
            return list;
        }

        private void rightTraversal(TreeNode root, List<Integer> list, int level) {
            if (root == null) return;

            if (level == list.size()) {
                list.add(root.val);
            }

            rightTraversal(root.right, list, level + 1);
            rightTraversal(root.left, list, level + 1);
        }
    }
}
