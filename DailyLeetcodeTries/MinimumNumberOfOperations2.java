package DailyLeetcodeTries;
import java.util.*;
public class MinimumNumberOfOperations2 {
    public static void main(String[] args) {
        int[] nums = {100,97,94,91,88,85,82,79,76,73,70,67,64,61,58,55,52,49,46,43};
        System.out.println(minOperations(nums));
    }
    static int minOperations(int[] nums) {
        Arrays.sort(nums);
        int uniqueLen = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueLen++] = nums[i];
            }
        }

        int ans = nums.length;
        for (int i = 0, j = 0; i < uniqueLen; ++i) {
            while (j < uniqueLen && nums[j] - nums[i] <= nums.length - 1) {
                ++j;
            }
            ans = Math.min(ans, nums.length - (j - i));
        }

        return ans;
    }
}
