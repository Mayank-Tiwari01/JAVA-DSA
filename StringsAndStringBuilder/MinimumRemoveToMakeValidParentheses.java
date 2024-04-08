package StringsAndStringBuilder;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {

    }
    static String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder str = new StringBuilder();
        Deque<Integer> dq = new LinkedList<>();
        //checking for closing brackets
        for (char c : s.toCharArray()) {
            if (c == ')' && balance == 0)
                continue;
            if (c == '(')
                balance++;
            if (c == ')')
                balance--;
            str.append(c);
        }
        balance = 0;
        //checking for opening brackets
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(' && balance == 0)
                str.deleteCharAt(i);
            else if (str.charAt(i) == '(')
                balance--;
            else if (str.charAt(i) == ')')
                balance++;
        }
        return str.toString();
    }
}
