package BinaryTrees;

public class BinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void printTreePreOrder() {
        printTreePreOrder(root);
    }

    private void printTreePreOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }
    public void printTreeInOrder() {
        printTreeInOrder(root);
    }
    private void printTreeInOrder(TreeNode root) {
        if (root == null)
            return;
        printTreeInOrder(root.left);
        System.out.print(root.data + " ");
        printTreeInOrder(root.right);
    }
    public void printTreePostOrder() {
        printTreePostOrder(root);
    }
    private void printTreePostOrder(TreeNode root) {
        if (root == null) return;
        printTreePostOrder(root.left);
        printTreePostOrder(root.right);
        System.out.print(root.data + " ");
    }
    static int idx = -1;

    private TreeNode buildTreePreOrder(int[] nodes) {
        idx++;
        if (idx >= nodes.length || nodes[idx] == -1) return null;
        TreeNode node = new TreeNode(nodes[idx]);
        node.left = buildTreePreOrder(nodes);
        node.right = buildTreePreOrder(nodes);
        return node;
    }

//    public static void main(String[] args) {
//        BinaryTree tree = new BinaryTree();
//
//        // Adding values to the original tree
//        tree.root = new TreeNode(1);
//        tree.root.left = new TreeNode(2);
//        tree.root.right = new TreeNode(3);
//        tree.root.left.left = new TreeNode(4);
//        tree.root.left.right = new TreeNode(5);
//        tree.root.right.left = new TreeNode(6);
//
//        // Using a pre-order array to build a tree
//        int[] nums = {11, 21, 41, -1, -1, 51, -1, -1, 31, -1, 61, -1, -1};
//        BinaryTree tree2 = new BinaryTree();
//        tree2.root = tree2.buildTreePreOrder(nums);
//
//        // Print the original tree
//        System.out.println("Original Tree (built using manual insertion) :");
//        tree.printTreePreOrder();
//        System.out.println();
//
//        // Print the constructed tree using pre-order traversal
//        System.out.println("Constructed Tree(pre order):");
//        tree2.printTreePreOrder();
//        System.out.println();
//
//        System.out.println("Constructed Tree(In-order):");
//        tree2.printTreeInOrder();
//        System.out.println();
//
//        System.out.println("Constructed Tree(post-order):");
//        tree2.printTreePostOrder();
//    }
}