package ArrayQuestions;

public class pivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndexCount(nums));
    }
    static int pivotIndexCount(int[] nums) {
        int len = nums.length;
        int totalSum = 0;

        for (int i : nums) {
            totalSum += i;
        }
        int currSum = 0;
        for (int i = 0; i < len; i++) {
            currSum += nums[i];
            int left = currSum - nums[i];
            int right = totalSum - currSum;
            if (left == right) return i;
        }
        return -1;
    }
}