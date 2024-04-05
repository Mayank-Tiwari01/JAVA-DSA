package StackAndQueue;
import java.util.*;
public class MakeTheStringGreatAgain {
    public static void main(String[] args) {
        String s = "sAAsA";
        System.out.println(makeGood(s));
    }
    static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32)
                stack.pop();
            else
                stack.add(c);
        }
        while (!stack.isEmpty())
            ans.append(stack.pop());

        return ans.reverse().toString();
    }
}