package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
public class slidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(maxSlidingWindow(nums, k));
    }
    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxNum = new LinkedList<>();
        int j = 0;

        for (int i = 0; i <= nums.length - k; i++) {

        }
        return nums;
    }
}
