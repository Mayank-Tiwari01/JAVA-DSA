package RecursionAndBacktracking;
import java.util.*;
public class SortAStack {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/sort-a-stack/1
    }
    public static Stack<Integer> sortStack(Stack<Integer> s) {
        sortingStack(s);
        return s;
    }
    static void sortingStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sortingStack(stack);

        insert(stack, temp);
    }
    static void insert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.add(temp);
            return;
        }
        int top = stack.pop();
        insert(stack, temp);
        stack.add(top);
    }
}
