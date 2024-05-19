package BinaryTrees;
/*
Did not understand why the solution works really.
//https://www.youtube.com/watch?v=QIiQdsVvjNw
 */
public class FindTheMaximumSumNodeValues {
    static class Solution {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            //the first value would be the max sum
            //second would be the xor count
            //third will be the minimum reduction.
            long[] maxSum = new long[3];
            maxSum[2] = Integer.MAX_VALUE;
            for (int num : nums) {
                if ((num ^ k) > num) {
                    maxSum[0] += num ^ k;
                    maxSum[1]++;
                } else
                    maxSum[0] += num;

                long nuksaan = Math.abs(num - (num ^ k));
                maxSum[2] = Math.min(maxSum[2], nuksaan);

            }
            if (maxSum[1] % 2 == 0)
                return maxSum[0];
            return maxSum[0] - maxSum[2];
        }
    }
}
