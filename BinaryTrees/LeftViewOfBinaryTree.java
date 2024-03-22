package BinaryTrees;
//gfg
public class LeftViewOfBinaryTree {
    static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            int leftMost = -1;
            boolean found = false;
            for (int i = 0; i < len; i++) {
                Node temp = queue.poll();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

                if (!found) {
                    leftMost = temp.data;
                    found = true;
                }

            }
            list.add(leftMost);
        }
        return list;
    }
}