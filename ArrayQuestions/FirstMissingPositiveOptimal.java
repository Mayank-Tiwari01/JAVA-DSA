package ArrayQuestions;

public class FirstMissingPositiveOptimal {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0)
                nums[i] = len + 1;
        }

        for (int k = 0; k < len; k++) {
            int idx = Math.abs(nums[k]);
            if (idx <= len && nums[idx - 1] > 0)
                nums[idx - 1] *= -1;
        }
        for (int j = 0; j < len; j++) {
            if (nums[j] >= 0)
                return j + 1;
        }
        return len + 1;
    }
}