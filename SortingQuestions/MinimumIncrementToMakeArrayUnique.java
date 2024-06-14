package SortingQuestions;
import java.util.Arrays;
public class MinimumIncrementToMakeArrayUnique {
    static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int op = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                op += (nums[i - 1] + 1) - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return op;
    }
}
