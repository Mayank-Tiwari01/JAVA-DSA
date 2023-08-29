package SortingQuestions;

import java.util.Arrays;

public class TwoSumUsingSort {
    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
    static int[] twoSum(int[] nums, int target) {
        int[] orignalArray = new int[nums.length];
        int index = 0;
        for (int num : nums) orignalArray[index++] = num;

        int[] sortedIndex = new int[2];

        Arrays.sort(nums);
        int length = nums.length;
        int start = 0;
        int end = length - 1;

        while (start < length && end >= 0) {
            if (nums[start] + nums[end] < target) {
                start++;
            }
            else if (nums[start] + nums[end] > target) {
                end--;
            }
            else {
                sortedIndex[0] = nums[start];
                sortedIndex[1] = nums[end];
                break;
            }
        }

        int[] orignalArrayIndex = new int[2];
        int j = 0;

        for (int i = 0; i < length; i++) {
            if (orignalArray[i] == sortedIndex[0]) {
                orignalArrayIndex[0] = i;
            }
            if (orignalArray[j] == sortedIndex[1] && j != i) {
                orignalArrayIndex[1] = j;
            }
            j++; // Increment j here
        }
        return orignalArrayIndex;
    }
}
