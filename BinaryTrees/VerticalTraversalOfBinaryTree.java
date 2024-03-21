package BinaryTrees;

import java.util.*;

public class VerticalTraversalOfBinaryTree {
    static ArrayList<Integer> verticalOrder(TreeNode root) {
        ArrayList<Integer> verticalOrder = new ArrayList<>();
        if (root == null) return verticalOrder;

        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();
        helper(root, 0, treeMap);

        for (ArrayList<Integer> list : treeMap.values()) {
            verticalOrder.addAll(list);
        }
        return verticalOrder;
    }
    //dfs won't work because we want to return the order of elements as they are in level order traversal.
    static void helper(TreeNode root, int dis, TreeMap<Integer, ArrayList<Integer>> treeMap) {
        if (root == null) return;

        helper(root.left, dis - 1, treeMap);
        treeMap.putIfAbsent(dis, new ArrayList<>());
        treeMap.get(dis).add(root.val);
        helper(root.right, dis + 1, treeMap);
    }
}
