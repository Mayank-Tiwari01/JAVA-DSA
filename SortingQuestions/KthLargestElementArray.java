package SortingQuestions;

import java.util.Arrays;
/* Min-Heap (priority queue (heap))
or QuickSelect Algorithm would be better obv.
 */
public class KthLargestElementArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(KthLargest(nums, k));
    }
    static int KthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

