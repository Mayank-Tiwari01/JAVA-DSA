package ArrayQuestions;

public class MaxConsecutiveOnesIII {
    static int longestOnes(int[] nums, int k) {
        int max = -1, start = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                k--;
            while (k < 0) {
                if (nums[start] == 0)
                    k++;
                start++;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
