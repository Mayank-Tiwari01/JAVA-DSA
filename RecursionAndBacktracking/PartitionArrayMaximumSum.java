package RecursionAndBacktracking;
//understand it properly later.
//https://www.youtube.com/watch?v=LvvIcZWtuoY
public class PartitionArrayMaximumSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7,8,9,1,2,56};
        int k = 4;
    }
     int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSum(arr, k, 0);
    }
    static int maxSum(int[] arr, int k, int idx) {
        if (idx >= arr.length)
            return 0;

        int max = -1;
        int result = 0;
        for (int i = idx; i < arr.length && i - idx + 1 <= k; i++) {
            max = Math.max(max, arr[i]);
            int currSubArrMax = (i - idx + 1) * max;
            result = Math.max(result, currSubArrMax + maxSum(arr, k, i + 1));
        }
        return result;
    }
}
