package StackAndQueue;
import java.util.*;
/*
https://www.geeksforgeeks.org/problems/expression-contains-redundant-bracket-or-not/1
Idea is between every '(' and ')' there should be an operator.
Whenever you find ')' you start popping because it signifies an end of an expression, And if while popping you do not
find an operator, then you return false or one.
I think this code is only good for the gfg problem, cause there weren't many edge cases there, so even if the string
has something like (*) then also this code will return true,
and gfg will accept, it says in the question that the expression
will be valid.
 */
public class ExpressionContainsRedundantBracketOrNot {
    public static void main(String[] args) {
        String s = "(b+c-d+(c))";
        System.out.println(checkRedundancy(s));
    }
    static int checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if ( c != ')') stack.push(c);
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
