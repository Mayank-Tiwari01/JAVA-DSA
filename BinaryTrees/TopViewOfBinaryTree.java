package BinaryTrees;
import java.util.*;
public class TopViewOfBinaryTree {
    static ArrayList<Integer> topView(TreeNode root)
    {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (temp.node.left != null) {
                queue.offer(new Pair(temp.node.left, temp.dis - 1));
            }
            if (temp.node.right != null) {
                queue.offer(new Pair(temp.node.right, temp.dis + 1));
            }

            map.putIfAbsent(temp.dis, temp.node.val);
        }
        //iterate on the treeMap, and add all the values.
        return new ArrayList<>(map.values());
    }
    static class Pair {
        TreeNode node;
        int dis;

        Pair(TreeNode node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
}
