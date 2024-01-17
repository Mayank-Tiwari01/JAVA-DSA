package StackAndQueue;

import java.util.Arrays;
import java.util.Stack;
/*
The trick here is copying the array twice, like if the array is 12343, make it 12343 12343. Now transverse from last,
and do not add anything in the answer array till you have half-way processed the array, i.e., till you have gone from
len * 2-1 to len (iterating from the back). Once you reach len - 1, start adding elements by the usual logic.
Dry run it yourself and you will understand.
https://www.youtube.com/watch?v=RkG94TvnUFs (this code in comments)
you do not even have to make a new array with copied elements, you can use i % len to access elements.
See this video to understand how to do it without copying array.
https://www.youtube.com/watch?v=Du881K7Jtk8&list=PLgUwDviBIf0oSO572kQ7KCSvCUh1AdILj&index=6
Just note that Striver made a mistake in the loop condition, it should be:
for (int i = (len * 2) - 1; i >= 0; i--)
 */
public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
    static int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];
        for (int i = (len * 2) - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[i % len] >= stack.peek()) {
                stack.pop();
            }
            if (i < len) {
                if (stack.isEmpty()) ans[i] = -1;
                else ans[i] = stack.peek();
            }
            stack.push(nums[i % len]);
        }
        return ans;
    }
}
/*
        int len = nums.length;
        int[] newArr = new int[len * 2];
        int temp = 0;

        while (temp < len * 2) {
            for (int num : nums) {
                newArr[temp] = num;
                temp++;
            }
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = (len * 2) - 1; i>= 0; i--) {
            while (!stack.empty() && stack.peek() <= newArr[i]) {
                stack.pop();
            }
            if (i < len) {
                if (stack.empty()) nums[i] = -1;
                else nums[i] = stack.peek();
            }
            stack.push(newArr[i]);
        }
        return nums;
 */