package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;
//next greater element to the right.
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }
    static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = 0;
            else
                ans[i] = stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}