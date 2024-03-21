package BinaryTrees;
import java.util.*;
//og code not og soch.
public class VerticalOrderTraversalOfBinaryTreeLCHard {
    static class Pair {
        TreeNode node;
        int vertical;
        int level;

        Pair(TreeNode node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalTraversal = new ArrayList<>();
        if (root == null) return verticalTraversal;
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        queue.offer(new Pair(root, 0, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();

            map.putIfAbsent(temp.vertical, new TreeMap<>());
            map.get(temp.vertical).putIfAbsent(temp.level, new PriorityQueue<>());
            map.get(temp.vertical).get(temp.level).offer(temp.node.val);

            if (temp.node.left != null)
                queue.offer(new Pair(temp.node.left, temp.vertical - 1, temp.level + 1));
            if (temp.node.right != null)
                queue.offer(new Pair(temp.node.right, temp.vertical + 1, temp.level + 1));
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {
            List<Integer> cols = new ArrayList<>();
            for (PriorityQueue<Integer> pq : levels.values()) {
                //do not use cols.addAll((pq)); Because it gives wrong answer. I do not know why.
                while (!pq.isEmpty()) {
                    cols.add(pq.poll());
                }
            }
            verticalTraversal.add(cols);
        }
        return verticalTraversal;
    }
}