package ArrayQuestions;
/*
https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
In gfg it is in ArrayList.
 */
public class MaxSumSubarrayofsizeK {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1};
        int k = 3;
        System.out.println(maxSubArrSum(nums, k));
    }
    static long maxSubArrSum(int[] nums, int k) {
        int j = 0;
        long maxSum = 0, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (i - j + 1 == k) {
                maxSum = Math.max(maxSum, currSum);
                currSum -= nums[j];
                j++;
            }
        }
        return maxSum;
    }
}


