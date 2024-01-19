package StackAndQueue;
import java.util.*;
/*
It's like finding the first greater value on the left. 2,_,_,_1 = so the stock span of 1 would be 3.
If the element is the greatest, then it will pop everyone and its span would be i + 1.
 */
public class StockSpanProblem {
    public static void main(String[] args) {
        int[] prices = {2, 2, 2, 2, 2, 2, 2};
        System.out.println(Arrays.toString(calculateSpan(prices, prices.length)));
    }
    public static int[] calculateSpan(int[] price, int n) {
        Stack <Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = i + 1;
            else ans[i] = i - stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
