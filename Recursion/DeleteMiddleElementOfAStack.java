package Recursion;
//https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
import java.util.*;

public class DeleteMiddleElementOfAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int size = 5;
        for (int i = 1; i <= 4; i++)
            stack.add(i);
        int middle = size / 2;
        deleteMiddleElement(stack, 0, middle);
        System.out.println(stack);
    }
    static void deleteMiddleElement(Stack<Integer> stack, int idx, int middle) {
        if (stack.isEmpty())
            return;

        int top = stack.pop();
        deleteMiddleElement(stack, idx + 1, middle);
        if (idx != middle) stack.push(top);
    }
}
