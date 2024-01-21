package StackAndQueue;
import java.util.*;
/*
Very similar to SumOfSubarrayMinimums
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {8,1};
        System.out.println(largestRectangleArea(arr));
    }
     static int largestRectangleArea(int[] arr) {
        int len = arr.length;
        int[] leftSmallest = LSN(arr, len);
        int[] rightSmallest = RSN(arr, len);

        int max = 0;

        for (int i = 0; i < len; i++) {
            int rectangle = rightSmallest[i] - leftSmallest[i] - 1;
            max = Math.max(max, rectangle * arr[i]);
        }
        return max;
    }
    static int[] LSN(int[] arr, int len) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] RSN(int[] arr, int len) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) ans[i] = len;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}