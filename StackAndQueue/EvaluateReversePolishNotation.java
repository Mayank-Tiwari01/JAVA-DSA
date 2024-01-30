package StackAndQueue;
import java.util.*;
/*
Easy, push if it is a number, if it is an operation then pop two numbers out of the stack and then do that operation
The number which is popped last is in the front while calculating, then push back the ans. The ans is what is stored in
the stack top.
Learn, Object.equals(), stringName.equals(), Long.parseLong(string). Also switch and case.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    static int evalRPN(String[] tokens) {
        Stack<Long> stack = new Stack<>();
        long ans = 0;

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/")
                    || token.equals("*")) {

                if (!stack.isEmpty()) {
                    long second = stack.pop();
                    long first = stack.pop();

                    ans = switch (token) {
                        case "+" -> first + second;
                        case "-" -> first - second;
                        case "*" -> first * second;
                        default -> first / second;
                    };
                    /*
                    if (Objects.equals(tokens[i], "+")) //or use token.equals("+") because it is what mostly used on strings
                        ans = first + second;
                    else if (Objects.equals(tokens[i], "-"))
                        ans = first - second;
                    else if (Objects.equals(tokens[i], "*"))
                        ans = first * second;
                    else
                        ans = first / second;
                     */
                }
                stack.push(ans);
            } else {
                stack.push(Long.parseLong(token));
            }
        }
        return stack.pop().intValue();
    }
}

