package StackAndQueue;

import java.util.*;
/*
The push() method adds an element to the beginning of the Deque
while the add() method adds an element to the end of the Deque.
The main difference between Queue.poll() and Queue.removeLast() is that
Queue.poll() returns null if the queue is empty, whereas Queue.removeLast()
throws an IllegalStateException if the queue is empty.
dq.getLast() retrieves but does not remove from the last.

Everything OG.
This is the first DQ question I ever tried, and it got submitted in one go, hard question huh.
I don't think I need to explain the logic.
But still:
If the dq is empty, add the index, you add elements from the back, if the back that is .getLast is actually smaller than
the element we are at right now,
then we remove the elements from the back until the dq is empty or the back element is larger.
If the start index goes past by the head of the dq, pop that element too, do a dry run, and it becomes pretty easy.
Just remember that when start goes past the dq.peek() you remove the head (obv) otherwise you always remove from the
last for simplicity.
 */
public class slidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,7,8,2,3,4,5,2};
        int k = 4;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int start = 0;

        for (int end = 0; end < len; end++) {
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[end]) {
                dq.removeLast(); //dq.poll() is not working here as expected, IDK why.
            }
            if (dq.isEmpty() || nums[dq.getLast()] > nums[end]) dq.add(end);
            if (end - start + 1 == k) {
                ans[start++] = nums[dq.peek()];
                if (start > dq.peek()) dq.remove();
            }
        }
        return ans;
    }
}
