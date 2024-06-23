package StackAndQueue;
import java.util.*;
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    static int longestSubarrayBrute(int[] nums, int limit) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int longestLen = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            minHeap.offer(nums[end]);
            maxHeap.offer(nums[end]);

            while (maxHeap.peek() - minHeap.peek() > limit) {
                //remove every occurrence of a number.
                minHeap.remove(nums[start]);
                maxHeap.remove(nums[start]);
                start++;
            }

            longestLen = Math.max(longestLen, (end - start + 1));
        }

        return longestLen;
    }
}
