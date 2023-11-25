package DailyLeetcodeTries;
/*
Got the logic after analyzing the test cases. Wrote the whole code by my own, wasn't very easy to come up, also did this during ETE.
Feeling a little good passing all the test cases in one go.
4 ms Beats 65.38% of users with Java.
It will give better runtime on leetcode if you do not make a separate function (possible reason given below).
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
/*
The performance difference between the two versions of the code might be attributed to several factors. Let's analyze the differences:

Function Call Overhead:

In the first version, there is a separate function (prefixSumArr) to calculate the prefix sum.
In the second version, the prefix sum is calculated inline within the main function.
Impact: Function calls typically introduce a small overhead. Inlining the prefix sum calculation in the second version might reduce this overhead.

Memory Allocation:

In the first version, a separate array (prefixSum) is created to store the prefix sums.
In the second version, the prefix sums are stored directly in the prefixSum array without the need for a separate array.
Impact: Memory allocation and array creation can have a minor impact on performance. The second version avoids the creation of a separate array, potentially reducing memory overhead.

Code Size:

The first version has a slightly larger code size due to the presence of a separate function.
Impact: Larger code size might affect cache utilization, leading to minor performance differences.

Compiler Optimization:

Compiler optimizations can play a significant role. Different compilers and optimization settings may produce varying results.
Impact: The compiler might optimize certain constructs differently, leading to performance variations.

Data Dependency:

The second version reduces data dependency by calculating the prefix sum in a single loop.
Impact: Reduced data dependency can improve pipeline utilization, potentially leading to better performance.
 */