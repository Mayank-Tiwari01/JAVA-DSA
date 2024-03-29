package ArrayQuestions;
//simple, it's harder to find the subarrays with the given condition, so do the opposite.
//and then subtract it with total subarrays.
public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int len = nums.length;
        long max = Long.MIN_VALUE;
        for (int i : nums)
            max = Math.max(max, i);
        long count = 0;
        int start = 0;
        long subArr = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] == max)
                count++;
            while (count >= k) {
                if (nums[start] == max)
                    count--;
                start++;
            }
            subArr += i - start + 1;
        }
        long totalSubArr = ((long) len * (len + 1)) / 2; // Ensure a long type for intermediate calculations
        return totalSubArr - subArr;
    }
}
