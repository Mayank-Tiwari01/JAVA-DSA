package StackAndQueue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "[[{{()}}]]{{}}[[[]]]((()))";
        System.out.println(isValid(s));
    }
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        stack.push('e');

        for (char c : s.toCharArray()) {
            char peek = stack.peek();

            if ((c == '{' || c == '[' || c == '(')&& (peek == 'e' || peek == '{'
                    || peek == '(' || peek == '[')) {

                stack.push(c);
            }

            else if ((c == '{' && peek == '}' )||(c == '(' && peek == ')' ) ||
            (c == '[' && peek== ']' )) {

                stack.pop();
            }

            else if ((c == '}' && peek == '{' )||(c == ')' && peek == '(' ) ||
                    (c == ']' && peek == '[' )) {

                stack.pop();
            }

            else {
                return false;
            }
        }
        return (stack.peek() == 'e');
    }
}
