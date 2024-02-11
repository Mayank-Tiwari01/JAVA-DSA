package BasicJavaPrograms;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class MaxWeightedLevel {
    static class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static int findMaxWeightedLevel(int numElements, int rootValue, int[] treeElements) {
        TreeNode root = new TreeNode(rootValue);

        TreeNode[] nodes = new TreeNode[numElements + 1];

        for (int i = 0; i < treeElements.length; i++) {
            nodes[i + 1] = new TreeNode(treeElements[i]);
        }

        for (int i = 1; i <= numElements; i++) {
            if (2 * i <= numElements) {
                nodes[i].left = nodes[2 * i];
            }
            if (2 * i + 1 <= numElements) {
                nodes[i].right = nodes[2 * i + 1];
            }
        }

        int maxWeight = 0;
        int maxLevel = 0;
        int level = 1;

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root, 1));

        while (!queue.isEmpty()) {
            int levelSum = 0;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Pair current = queue.poll();
                levelSum += current.node.val;

                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, current.level + 1));
                }
                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, current.level + 1));
                }
            }

            int levelWeight = levelSum / levelSize;

            if (levelWeight > maxWeight) {
                maxWeight = levelWeight;
                maxLevel = level;
            }
            level++;
        }
        return maxLevel;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numElements = scanner.nextInt();

        int rootValue = scanner.nextInt();

        int[] treeElements = new int[numElements];

        for (int i = 0; i < numElements; i++) {
            treeElements[i] = scanner.nextInt();
        }

        int temp = findMaxWeightedLevel(numElements, rootValue, treeElements);

        System.out.println(temp);
    }
}
