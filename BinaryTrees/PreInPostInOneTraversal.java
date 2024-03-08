package BinaryTrees;
//nice
import java.util.*;
public class PreInPostInOneTraversal {
    class Pair {
        TreeNode node;
         int value;

        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> allTransverses(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(root, 1));

        while(!stack.isEmpty()) {
            Pair temp = stack.pop();
            if (temp.value == 1) {
                preOrder.add(temp.node.val);
                stack.add(new Pair(temp.node, 2));
                if (temp.node.left != null)
                    stack.add(new Pair(temp.node.left, 1));
            }
            if (temp.value == 2) {
                inOrder.add(temp.node.val);
                stack.add(new Pair(temp.node, 3));
                if (temp.node.right != null)
                    stack.add(new Pair(temp.node.right, 1));
            }
            if (temp.value == 3) {
                postOrder.add(temp.node.val);
            }
        }
        ans.add(preOrder);
        ans.add(inOrder);
        ans.add(postOrder);

        return ans;
    }
    public static void main(String[] args) {
        PreInPostInOneTraversal solution = new PreInPostInOneTraversal();

        PreInPostInOneTraversal.TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.right.left = solution.new TreeNode(4);
        root.right.right = solution.new TreeNode(5);

        // Call the allTransverses method and get the result
        List<List<Integer>> result = solution.allTransverses(root);

        System.out.println("Preorder: " + result.get(0));
        System.out.println("Inorder: " + result.get(1));
        System.out.println("Postorder: " + result.get(2));
    }
}