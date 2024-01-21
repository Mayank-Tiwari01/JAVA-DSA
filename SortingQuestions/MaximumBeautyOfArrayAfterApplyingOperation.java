package SortingQuestions;

import java.util.Arrays;
/*
Approach is 50% OG I guess, written code is OG. I knew we had to do something with the starting and ending range.
But got the idea of sorting and looking for overlapping ranges from comments, and sliding window from topics.
The idea is if we sort the numbers, then the numbers with closer ranges come together because we are calculating range
as nums[i] - k to nums[i] + k. So after finding out the ranges, check if the end range is between the starting range and
ending range of a number if yes, then those ranges are overlapping. Comments were helpful in this question, so read those.
Will try to do this with constant space and with binary search.
 */
public class MaximumBeautyOfArrayAfterApplyingOperation {
    public static void main(String[] args) {
        int[] nums = {3,5,3,5,1,2,67};
        int k = 4;
    }
    static int maximumBeauty(int[] nums, int k) {
        int len = nums.length;
        int[] sIdx = new int[len];
        int[] eIdx = new int[len];
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            sIdx[i] = Math.max(0, nums[i] - k);
            eIdx[i] = nums[i] + k;
        }

        int first = 0, second = 0;
        int larLen = 1;
        while (second < len) {
            if (eIdx[first] >= sIdx[second] && eIdx[first] <= eIdx[second]) {
                second++;
            }
            else {
                first++;
            }
            larLen = Math.max(larLen, second - first);
        }

        return larLen;
    }
}