package DailyLeetcodeTries;
/*
Wrong Answer
7 / 72 testcases passed
 */
public class MaximumScoreOfGoodSubarray {
    public static void main(String[] args) {
        int[] nums = {5,5,4,5,4,1,1,1};
        int k = 0;
        System.out.println(maxScore(nums, k));
    }
    static int maxScore(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        int minIdx = minElement(nums, start, end);
        int maxScore = calculateScore(nums, minIdx, start, end);

        while (end >= k) {
            if (start <= k) {
                if (start >= minIdx || end <= minIdx) {
                    minIdx = minElement(nums, start, end);
                }
                maxScore = Math.max(maxScore, calculateScore(nums, minIdx, start, end));
                start ++;
            }
            if (start >= k) {
                start = 0;
                end--;
            }
        }

        return maxScore;
    }
    static int minElement (int[] nums, int start, int end) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    static int calculateScore (int[] nums, int minIdx, int start, int end) {
        return nums[minIdx] * (end - start + 1);
    }
}
