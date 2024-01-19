package StackAndQueue;
import java.util.*;
public class smallerNumberToTheRightGFG {
    public static void main(String[] args) {
        int[] a= {1,2,3,4,5,3,-4,42,1,23,23,232,3,2,1,90};
        System.out.println(leftSmaller(a.length, a));
    }
    static List<Integer> leftSmaller(int n, int[] a) {
        Stack <Integer> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= a[i]) stack.pop();
            if (stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());
            stack.push(a[i]);
        }
        return ans;
    }
}