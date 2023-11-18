package DailyLeetcodeTries;
import java.util.Arrays;
public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int [] arr = {1,2,4};
        int k = 5;
        System.out.println(maxFreq(arr, k));
    }
    static int maxFreq(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 1;
        int [] sum = prefixSumArray(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            int result = binarySearch(nums, sum, i, k);
            maxFreq = Math.max(result, maxFreq);
        }
        return maxFreq;
    }
    static int binarySearch(int[] nums, int[] sum, int target, int k) {
        int start = 0;
        int end = target;
        int ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int diff = (target - mid + 1) * nums[target] - prefixSum(sum, mid, target);
            if (diff > k) {
                start = mid + 1;
            }
            else {
                ans = Math.max(ans, target - mid + 1);
                end = mid;
            }
        }
        return ans;
    }
    static int[] prefixSumArray(int[] nums) {
        int[] sum = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            sum[i] = temp;
        }
        return sum;
    }
    static int prefixSum(int[] sum , int start, int end) {
        if (start == 0) {
            return sum[end];
        }
        return sum[end] - sum[start - 1];
    }
}
