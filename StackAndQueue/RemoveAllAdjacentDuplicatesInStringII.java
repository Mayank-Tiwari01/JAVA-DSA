package StackAndQueue;
import java.util.*;
public class RemoveAllAdjacentDuplicatesInStringII {
    static class pair {
        char c;
        int freq;

        public pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }
    static String removeDuplicates(String s, int k) {
        Stack<pair> stack = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek().c != s.charAt(i))
                stack.add(new pair(s.charAt(i), 1));
            else {
                if (stack.peek().c == s.charAt(i) && stack.peek().freq + 1 == k) {
                    stack.pop();
                } else if (stack.peek().c == s.charAt(i) && stack.peek().freq + 1 < k) {
                    pair temp = stack.pop();
                    stack.add(new pair(s.charAt(i), temp.freq + 1));
                }
            }
        }
        StringBuilder str = new StringBuilder();

        while (!stack.empty()) {
            pair top = stack.pop();
            int freq = top.freq;
            while (freq > 0){
                str.append(top.c);
                freq--;
            }
        }
        return str.toString();
    }
}
