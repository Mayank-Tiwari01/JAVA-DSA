package BS;

import java.util.Arrays;

public class ApplyOperationsToMaximizeFrequencyScore {
    public static void main(String[] args) {
        int[] nums = {6,29,3,19,10,6,20,26,25,29,12,29,14,15,16,5};
        long k = 64;
        System.out.println(binarySearch(nums, k));
    }
    static int binarySearch(int[] nums, long k) {
        Arrays.sort(nums);
        int minFreq = 1, maxFreq = nums.length;
        int ans = 1;
        while(minFreq <= maxFreq) {
            int midFreq = minFreq + (maxFreq - minFreq) / 2;

            if (isPossible(midFreq, nums, k)) {
                ans = midFreq;
                minFreq = midFreq + 1;
            }
            else {
                maxFreq = midFreq - 1;
            }
        }
        return ans;
    }
     static boolean isPossible(int midFreq, int[] nums, long k) {
        int length = nums.length;
        long[] prefixSumArr = new long[length + 1];
        prefixSum(nums, prefixSumArr);
        int start = 0, end = midFreq - 1;

        while (end < length) {
            int midValue = start + (end - start) / 2;
            long leftPart = (nums[midValue] * (midValue - start)) - (prefixSumArr[midValue] - prefixSumArr[start]);
            long rightPart = (prefixSumArr[(end + 1)] - prefixSumArr[(midValue + 1)]) - (nums[midValue] * (end - midValue));

            if (k - (leftPart + rightPart) >= 0) return true;
            start++;
            end++;
        }
        return false;
    }
    static void prefixSum(int[] nums, long[] prefixSumArr) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSumArr[i + 1] = sum;
        }
    }
}
