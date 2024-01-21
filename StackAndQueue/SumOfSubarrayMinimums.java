package StackAndQueue;
import java.util.*;
/*
The idea is form subarrays where the number [i] will be the smallest and then calculate
the sum. The formula is i - leftSmallest[i] to know the numbers which are on the right
side of the subarray for right side it is rightSmallest - i. Multiply them with the number
to know the sum of this subarray, do this for each subarray. Also look for duplicates and
integer overflow.
Watch this video IK you have forgotten the approach.
https://www.youtube.com/watch?v=HRQB7-D2bi0&t=1056s
 */
public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        System.out.println(sumSubarrayMins(arr));
    }
    static int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] leftSmallest = LSN(arr, len);
        int[] rightSmallest = RSN(arr, len);
        int mod = (int) 1e9 + 7;

        long sum = 0;
        for (int i = 0; i < len; i++) {
            long left = i - leftSmallest[i];
            long right = rightSmallest[i] - i;

            long totalSize = (left * right * arr[i]) % mod;
            sum = (sum + totalSize) % mod;
        }
        return (int) sum % mod;
    }
    static int[] LSN(int[] arr, int len) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
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

        //use >= or <= in one of the RSN or LSN to avoid
        //duplicates added, so if 2 appears two times, we will take it
        //once by using = and would not use it by using < or >.
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