package DailyLeetcodeTries;

import java.util.Arrays;
/*
Runtime
52 ms
Beats
93.56% of users with Java
 */
public class MinimizeMaximumPairSumInArray {
    public static void main(String[] args) {
        int[] nums = {3,5,4,2,4,6}; // nums.length will always be even.
        System.out.println(maxPairSum(nums));
    }
    static int maxPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int max = Integer.MIN_VALUE;

        while (start < end) {
            int sum = nums[start] + nums[end];
            start++;
            end--;
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
