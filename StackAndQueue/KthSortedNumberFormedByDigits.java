package StackAndQueue;

import java.util.PriorityQueue;
//Class example
/*
Form a sorted sequence by choosing digits from the array and arranging them in ascending order.
Sorted sequence: [1, 2, 3, 11, 12, 13, 21, 22, 23, 31, 32, 33, ...]
Find the 4th sorted number from this sequence.
Solution:
The 4th sorted number is 11.
 */
public class KthSortedNumberFormedByDigits {
    public static void main(String[] args) {
        int[] nums = {1,9};
        int k = 10;
        int result = findKthSortedNumber(nums, k);

        System.out.println("The " + k + "th sorted number is: " + result);
    }
    public static int findKthSortedNumber(int[] nums, int k) {
        // Create a priority queue to efficiently maintain the sorted sequence of numbers
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Initialize the priority queue with single-digit numbers from the array
        for (int num : nums) {
            priorityQueue.offer(num);
        }

        // Build the sorted sequence until reaching the kth number or the priority queue is empty
        while (k > 1 && !priorityQueue.isEmpty()) {
            // Retrieve the smallest number from the priority queue
            int current = priorityQueue.poll();

            // Concatenate each digit from the array to the current number and add to the priority queue
            for (int num : nums) {
                // Ensure that the result won't cause an overflow
                if (current * 10L + num <= Integer.MAX_VALUE) {
                    priorityQueue.offer((int) (current * 10 + num));
                }
            }

            // Decrement k to keep track of the progress in forming the sequence
            k--;
        }

        // Return the kth sorted number, or -1 if the priority queue is empty
        return priorityQueue.isEmpty() ? -1 : priorityQueue.poll();
    }
}
