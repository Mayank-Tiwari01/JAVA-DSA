package DailyLeetcodeTries;
/*
Got the logic after analyzing the test cases. Wrote the whole code by my own, wasn't very easy to come up, also did this during ETE.
Feeling a little good passing all the test cases in one go.
4 ms Beats 65.38% of users with Java.
It will give better runtime on leetcode if you do not make a separate function.
TC: O(n) and SC: O(n).
 */
import java.util.Arrays;

public class SumOfAbsoluteDifferencesInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,4,6,8,10};
        System.out.println(Arrays.toString(sumOfDiff(nums)));
    }
    static int[] sumOfDiff(int[] nums) {
        int len = nums.length;
        int[] prefixSum = prefixSumArr(nums, len);
        int[] sumOfDiff = new int[len];

        for (int i = 0; i < len; i++) {
            int x = (prefixSum[len] - prefixSum[i]) - (nums[i] * (len - i));
            int y = (nums[i] * i) - prefixSum[i];
            sumOfDiff[i] = x + y;
        }
        return sumOfDiff;
    }
    static int[] prefixSumArr(int[] nums, int len) {
        int[] sums = new int[len + 1];
        sums[0] = 0;
        int sum = 0;
        int index = 1;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sums[index] = sum;
            index++;
        }
        return sums;
    }
}
