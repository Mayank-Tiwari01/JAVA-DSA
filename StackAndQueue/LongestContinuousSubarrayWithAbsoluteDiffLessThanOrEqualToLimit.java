package StackAndQueue;
import java.util.*;
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    static class Pair {
        int val;
        int idx;

        public Pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    static int longestSubarrayBrute(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.val));
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.val).reversed());
        int longestLen = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            minHeap.offer(new Pair(nums[end], end));
            maxHeap.offer(new Pair(nums[end], end));

            while (maxHeap.peek().val - minHeap.peek().val > limit) {
                if (maxHeap.peek().idx == start)
                    maxHeap.poll();
                if (minHeap.peek().idx == start)
                    minHeap.poll();
                start++;
            }

            longestLen = Math.max(longestLen, (end - start + 1));
        }

        return longestLen;
    }
    static int longestSubarrayBetter(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2.val, p1.val));
        int longestLen = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            minHeap.offer(new Pair(nums[end], end));
            maxHeap.offer(new Pair(nums[end], end));

            // Ensure the current window satisfies the condition
            while (!minHeap.isEmpty() && !maxHeap.isEmpty() && (maxHeap.peek().val - minHeap.peek().val > limit)) {
                start++;
                // Remove elements out of the window from the heaps
                while (!minHeap.isEmpty() && minHeap.peek().idx < start) {
                    minHeap.poll();
                }
                while (!maxHeap.isEmpty() && maxHeap.peek().idx < start) {
                    maxHeap.poll();
                }
            }
            longestLen = Math.max(longestLen, (end - start + 1));
        }
        return longestLen;
    }
}
