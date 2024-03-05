package BinaryTrees;

public class BinaryTree {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            //no need for this as in java left and right are by default set as null.
           //this.left = this.right = null;
        }
    }

    private TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(TreeNode root) {
        //pre order traversal.
        if (root != null) {
            System.out.print(root.data + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        // Adding values to the tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);

        tree.printTree();

        TreeNode temp = new TreeNode(12);
        temp.left = new TreeNode(1);
        temp.right = new TreeNode(2);
        System.out.println(" ");
        tree.printTree(temp);
    }
}

