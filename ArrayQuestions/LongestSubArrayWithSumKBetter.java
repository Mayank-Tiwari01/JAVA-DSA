package ArrayQuestions;

import java.util.HashMap;

import static ArrayQuestions.PrefixSumArray.prefixSum;

public class LongestSubArrayWithSumKBetter {
    public static void main(String[] args) {
        int[] arr = {-13, -9, 16, 10, 19, 15, 5, 17, 10, 5, 6};
        int k = 4;
        System.out.println(longestSubArr(arr, k));
    }
    static int longestSubArr(int[] arr, int k) {
        HashMap <Integer, Integer> prefixSum = new HashMap<>();
        int longestLen = 0, sum = 0;
        //  prefixSum.put(0, -1);

/*        ==> prefixSum.put(0, -1);
this does the same thing as
        if (sum == k) {
            longestLen = i + 1;
        }
        explanation = what if the cumulative sum equals k, that means from the start of the
        array we found a subarray which has the sum k, so prefixSum.get(sum - k) will ask if there is zero,
        and we can save it at -1 so that when calculating i - prefixSum.get(sum - k) it gives you the correct length.
 */
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                longestLen = i + 1;
            }
            if (prefixSum.containsKey(sum - k)) {
                longestLen = Math.max(i - prefixSum.get(sum - k), longestLen);
            }
            if (!prefixSum.containsKey(sum )) {
                prefixSum.put(sum, i);
            }
        }
        return longestLen;
    }
}
