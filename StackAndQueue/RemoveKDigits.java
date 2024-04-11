package StackAndQueue;
import java.util.*;
public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "1173";
        System.out.println(removeKdigits(s, 2));
    }
    static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int i = 0, len = num.length();
        if (k == len) return "0";
        if (k == 0) return num;

        for (i = 0; i < len; i++) {
            while (!stack.isEmpty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
            if (k == 0) break;
        }
        StringBuilder str = new StringBuilder();

        while (!stack.isEmpty())
            str.insert(0, stack.pop());
        if (i < len)
            str.append(num, i + 1, len);
        if (k > 0)
            str.delete(str.length() - k, str.length());
        int j = 0;
        for (j = 0; j < str.length(); j++) {
            if (str.charAt(j) != '0')
                break;
        }
        str.delete(0, j);
        return (str.length() == 0) ? "0" : str.toString();
    }
}
