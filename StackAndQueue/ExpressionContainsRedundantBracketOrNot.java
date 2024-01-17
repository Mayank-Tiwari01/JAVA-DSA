package StackAndQueue;
import java.util.*;
/*
https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1
Idea is between every '(' and ')' there should be an operator.
Whenever you find ')' you start popping because it signifies an end of an expression. And if while popping if you do not
find an operator, then you return false or one.
 */
public class ExpressionContainsRedundantBracketOrNot {
    public static void main(String[] args) {
        String s = "(b+c-d+(c))";
        System.out.println(checkRedundancy(s));
    }
    static int checkRedundancy(String s) {
        // code here
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ( c != ')') stack.push(c);

            else if (!stack.empty() && stack.peek() == '(') return 1;
            else if(stack.empty()) return 1;
            else {
                boolean isOp = false;
                while (!stack.empty() && stack.peek() != '(') {
                    if (stack.peek() == '*' || stack.peek() == '+' || stack.peek() == '/'
                    || stack.peek() == '-') isOp = true;
                    stack.pop();
                }
                if (!isOp) return 1;
                if (!stack.empty()) stack.pop();
            }
        }

        return 0;
    }
}
