package BinaryTrees;
import java.util.Scanner;

class BinaryTreeScanner {
    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    //insert elements into the BT
    public void populate(Scanner sc) {
        System.out.println("Enter the root node: ");
        int value = sc.nextInt();
        root = new Node(value);
        populate(sc, root);
    }

    private void populate(Scanner sc, Node node) {
        // Enter the left values.
        System.out.println("Do you want to enter the value in the left of " + node.value);
        boolean leftBool = sc.nextBoolean();
        if (leftBool) {
            System.out.println("Please enter the left value of " + node.value + " :");
            int leftValue = sc.nextInt();
            node.left = new Node(leftValue);
            populate(sc, node.left);
        }

        // Enter the right values.
        System.out.println("Do you want to enter the value in the right of " + node.value);
        boolean rightBool = sc.nextBoolean();
        if (rightBool) {
            System.out.println("Please Enter the right value of " + node.value + " :");
            int rightValue = sc.nextInt();
            node.right = new Node(rightValue);
            populate(sc, node.right);
        }
    }

    public void printTree() {
        printTree(root, "");
    }
    private void printTree(Node node, String prefix) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + "├── " + node.value);

        // Print left subtree with increased prefix
        printTree(node.left, prefix + "│   ");

        // Print right subtree with increased prefix
        printTree(node.right, prefix + "│   ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreeScanner binaryTree = new BinaryTreeScanner();
        binaryTree.populate(sc);
        binaryTree.printTree();
    }
}