package BinaryTrees;

public class DiameterOfBinaryTree {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static int diameterOfBinaryTree(TreeNode root) {
        int[] maxLen = new int[1];
        findHeight(root, maxLen);
        return maxLen[0];
    }
    //bruteForce
    static  int helper(TreeNode root, int[] maxLen) {
        if (root == null) return 0;
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        //go to every node and then calculate l + r.
        int len = left + right;
        maxLen[0] = Math.max(len, maxLen[0]);

        helper(root.left, maxLen);
        helper(root.right, maxLen);

        return maxLen[0];
    }
    static int findHeight(TreeNode root) {
        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return 1 + Math.max(left, right);
    }
    //optimal
    static int findHeight(TreeNode root, int[] maxLen) {
        if (root == null) return 0;

        int left = findHeight(root.left, maxLen);
        int right = findHeight(root.right, maxLen);

        // Update maxLen with the diameter passing through the current node
        maxLen[0] = Math.max(maxLen[0], left + right);

        // Return the height of the current subtree
        return 1 + Math.max(left, right);
    }
}

