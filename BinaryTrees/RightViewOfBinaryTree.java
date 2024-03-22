package BinaryTrees;
//do watch the lc submission history of this one lol
//https://leetcode.com/problems/binary-tree-right-side-view/submissions/1208525048/
public class RightViewOfBinaryTree {
    //bfs--best
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            int rightMost = -1;

            for (int i = 0; i < len; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                rightMost = temp.val;
            }
            list.add(rightMost);
        }
        return list;
    }
    //recurcsive by gpt
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightTraversal1(root, list, 0);
        return list;
    }

    private void rightTraversal1(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;

        if (level == list.size()) {
            list.add(root.val);
        }

        rightTraversal(root.right, list, level + 1);
        rightTraversal(root.left, list, level + 1);
    }
}