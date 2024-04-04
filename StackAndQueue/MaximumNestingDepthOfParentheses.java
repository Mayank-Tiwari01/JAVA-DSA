package StackAndQueue;
import java.util.*;
public class MaximumNestingDepthOfParentheses {
    public static void main(String[] args) {
        String s = "8*((1*(5+6))*(8/6))";
        System.out.println(maxDepth(s));
    }
    static int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxCount = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                stack.add(c);
            }
            else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
/*
without stack
class Solution {
    public int maxDepth(String s) {
        int maxCount = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                count++;
            else if (c == ')')
                count--;

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
 */
