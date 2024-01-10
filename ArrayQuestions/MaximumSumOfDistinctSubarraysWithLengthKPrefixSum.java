package ArrayQuestions;

import java.util.HashMap;
/*
In this code, we just update the maxSum value when we happen to find a unique subarray of k length.
Beats ~80%
 */
public class MaximumSumOfDistinctSubarraysWithLengthKPrefixSum {
    public static void main(String[] args) {
        int[] nums = {4,3,3,3,2};
        int k = 5;
        System.out.println(maxSubArrSum(nums, k));
    }
    static long maxSubArrSum(int[] nums, int k) {
        int len = nums.length, idx = 1;
        long sum = 0;
        long[] prefixSumArr = new long[len + 1];
        for (int num : nums) {
            sum += num;
            prefixSumArr[idx++] = sum;
        }

        HashMap<Integer, Integer> numIdx = new HashMap<>();
        long maxSum = 0;
        int s = 0; //start idx. i is end idx.
        for (int i = 0; i < len; i++) {
            if ((!numIdx.containsKey(nums[i]) || numIdx.get(nums[i]) < s) && i - s + 1 == k) {
                long temp = prefixSumArr[i + 1] - prefixSumArr[s];
                maxSum = Math.max(maxSum, temp);
                s++;
            }
            if (numIdx.containsKey(nums[i]) && numIdx.get(nums[i]) >= s) {
                s = numIdx.get(nums[i]) + 1;
            }
            numIdx.put(nums[i], i);
        }
        return maxSum;
    }
}