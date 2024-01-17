package StackAndQueue;

import java.util.Stack;

public class reverseString {
    public static void main(String[] args) {
        String s = "WhyAmIEvenCodingThis?";
        System.out.println(reverse(s));
    }
    static String reverse(String s) {
        StringBuilder reverse = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) stack.push(c);

        while (!stack.empty()) {
            reverse.append(stack.pop());
        }
        return reverse.toString();
    }
}
