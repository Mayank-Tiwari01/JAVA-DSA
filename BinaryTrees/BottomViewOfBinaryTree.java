package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    static ArrayList<Integer> topView(TreeNode root)
    {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TopViewOfBinaryTree.Pair> queue = new LinkedList<>();
        queue.add(new TopViewOfBinaryTree.Pair(root, 0));

        while (!queue.isEmpty()) {
            TopViewOfBinaryTree.Pair temp = queue.poll();
            if (temp.node.left != null) {
                queue.offer(new TopViewOfBinaryTree.Pair(temp.node.left, temp.dis - 1));
            }
            if (temp.node.right != null) {
                queue.offer(new TopViewOfBinaryTree.Pair(temp.node.right, temp.dis + 1));
            }
            map.put(temp.dis, temp.node.val); //override everytime, to get the last value only.
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
