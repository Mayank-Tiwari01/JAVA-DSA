package Recursion;

import java.util.*;

public class ReverseAStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 5; i >= 1; i--)
            stack.push(i);

        System.out.println(stack);
        reverseStackConst(stack);
        System.out.println(stack);
    }
    static void reverseStack(Stack<Integer> St) {
        if(St.empty()) {
            return;
        }

        int top = St.pop();

        reverseStack(St);


        Stack<Integer> temp = new Stack<>();
        while(!St.empty()) {
            temp.push(St.pop());
        }

        St.push(top); //push at bottom

        //Now push remaining elements
        while(!temp.empty()) {
            St.push(temp.pop());
        }
    }
    static void reverseStackConst(Stack<Integer> stack) {
        //so basically what we are doing is
        //we are removing the top element and then calling the function again, which removes the top element too
        //when the stack becomes empty, you add the element that you last popped, and then the insert at bottom function
        // reverses it one by one, it will remove all the elements, add the element which you will give, and then
        //every time it has to add something it will remove again, and then add the element that you give, then it adds
        //the element it popped freshly.
        //no videos explain it properly with dry run, please see the classmate notes.
        if (stack.isEmpty())
            return;

        int temp = stack.pop();
        reverseStackConst(stack);

        insertAtBottom(stack, temp);
    }
    static void insertAtBottom(Stack<Integer> stack, int insert) {
        if (stack.isEmpty()) {
            stack.push(insert);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, insert);
        stack.push(temp);
    }
}
