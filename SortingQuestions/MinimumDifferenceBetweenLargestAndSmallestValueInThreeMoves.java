package SortingQuestions;
import java.util.Arrays;
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    static int minDifference(int[] nums) {
        int len = nums.length;

        if (len <= 4) return 0;

        Arrays.sort(nums);
        int minDif = Integer.MAX_VALUE;

        minDif = Math.min(minDif, nums[len - 1] - nums[3]);
        minDif = Math.min(minDif, nums[len - 2] - nums[2]);
        minDif = Math.min(minDif, nums[len - 3] - nums[1]);
        minDif = Math.min(minDif, nums[len - 4] - nums[0]);

        return minDif;
    }
}
