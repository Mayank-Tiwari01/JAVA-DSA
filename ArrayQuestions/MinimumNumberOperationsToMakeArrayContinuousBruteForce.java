package ArrayQuestions;
import java.util.*;
public class MinimumNumberOperationsToMakeArrayContinuousBruteForce {
    public static void main(String[] args) {
        int[] nums = {41,33,29,33,35,26,47,24,18,28}; //5
    }
    static int minOp(int[] nums) {
        int n = nums.length;

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int leftRange = nums[i];
            int rightRange = leftRange + n - 1;

            int mehnat = 0;

            Set<Integer> used = new HashSet<>();

            for (int j = 0; j < n; j++) {
                if (nums[j] >= leftRange && nums[j] <= rightRange && !used.contains(nums[j])) {
                    used.add(nums[j]);
                } else {
                    mehnat++;
                }
            }

            result = Math.min(result, mehnat);
        }

        return result;
    }
}



