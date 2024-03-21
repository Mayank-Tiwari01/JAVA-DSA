package BinaryTrees;

import java.util.*;

public class VerticalTraversalOfBinaryTree {
    static class Pair {
        TreeNode node;
        int dis;

        Pair(TreeNode node, int dis) {
            this.node = node;
            this.dis = dis;
        }
    }
    static ArrayList<Integer> verticalOrder(TreeNode root) {
        ArrayList<Integer> verticalOrder = new ArrayList<>();
        if (root == null) return verticalOrder;

        //I could have used a TreeMap instead, but Hashmap is more optimal and has less overhead.
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            if (temp.node.left != null) {
                queue.offer(new Pair(temp.node.left, temp.dis - 1));
                min = Math.min(min, temp.dis - 1);
            }
            if (temp.node.right != null) {
                queue.offer(new Pair(temp.node.right, temp.dis + 1));
                max = Math.max(max, temp.dis + 1);
            }

            map.putIfAbsent(temp.dis, new ArrayList<>());
            map.get(temp.dis).add(temp.node.val);
        }
        for (int i = min; i <= max; i++) {
            verticalOrder.addAll(map.get(i));
        }
        return verticalOrder;
    }
    //dfs won't work because we want to return the order of elements as they are in level order traversal.
    //so it is wrong, I should probably delete it, but I would not.
    static void helper(TreeNode root, int dis, TreeMap<Integer, ArrayList<Integer>> treeMap) {
        if (root == null) return;

        helper(root.left, dis - 1, treeMap);
        treeMap.putIfAbsent(dis, new ArrayList<>());
        treeMap.get(dis).add(root.val);
        helper(root.right, dis + 1, treeMap);
    }
}
