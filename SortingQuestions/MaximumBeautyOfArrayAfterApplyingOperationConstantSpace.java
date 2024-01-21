package SortingQuestions;

import java.util.Arrays;

public class MaximumBeautyOfArrayAfterApplyingOperationConstantSpace {
    public static void main(String[] args) {
        int[] nums = {3,5,3,5,1,2,67};
        int k = 4;
    }
    static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int first = 0, second = 0;
        int larLen = 1;
        int endRangeFirst = nums[first] + k;
        while (second < len) {
            int startRangeSecond = Math.max(0, nums[second] - k);
            int endRangeSecond = nums[second] + k;
            if (endRangeFirst >= startRangeSecond && endRangeFirst <= endRangeSecond) {
                second++;
            }
            else {
                first++;
                endRangeFirst = nums[first] + k;
            }
            larLen = Math.max(larLen, second - first);
        }

        return larLen;
    }
}