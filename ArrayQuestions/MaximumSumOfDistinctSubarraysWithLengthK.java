package ArrayQuestions;

import java.util.*;
/*
The only mistake that made me fail those 2 test cases out 92 is that I assumed that if duplicates elements are there
they'd be together, like 3,2,2,1,7. So I can just update my start pointer to the duplicate element found.
But what if the test case is like 3,2,3,1. I think this is the mistake I did in that blood-sucking question
LongestSubstringWithoutRepeatingCharacters. Please do better next time.
Also, I know I should have used Prefix Sum (will try later)
(tried) and I do not think it is much better tbh, beats 79.60%.
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1};
        int k = 3;
        System.out.println(maxSubArrSum(nums, k));
    }
    static long maxSubArrSum(int[] nums, int k) {
        HashMap <Integer, Integer> numIdx = new HashMap<>();
        long maxSum = 0;
        int j = 0, len = nums.length;
        long currSum = 0;
        for (int i = 0; i < len; i++) {
            if (!numIdx.containsKey(nums[i]) || numIdx.get(nums[i]) < j) {
                currSum += nums[i];
            }
            else if (numIdx.containsKey(nums[i]) && numIdx.get(nums[i]) >= j) {
                j = numIdx.get(nums[i]) + 1;
                i = j;
                currSum = nums[j];
            }
            if (i - j + 1 == k ) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[j];
                j++;
            }
            numIdx.put(nums[i], i);
        }
        return maxSum;
    }
}