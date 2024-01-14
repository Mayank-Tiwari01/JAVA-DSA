package ArrayQuestions;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target = 11;
        System.out.println(minSubArrayLen(target, nums));
    }
   static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int start = 0, end = 0, minSize = Integer.MAX_VALUE, sum = 0;

        while (start < len) {
            if (end < len && sum < target) {
                sum += nums[end];
                end++;
            }
            if (sum >= target) {
                minSize = Math.min(minSize, end - start );
                sum -= nums[start];
                start++;
                if (sum >= target) minSize = Math.min(minSize, end - start );
            }
            if (end == len && sum < target) break;
        }
        return (minSize == Integer.MAX_VALUE)? 0 : minSize;
    }
}
