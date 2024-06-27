package ArrayQuestions;

public class NextPermutation {
    static void nextPermutation(int[] nums) {
        int len = nums.length;
        int breakPoint = -1;

        if (len == 1) return;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                breakPoint = i - 1;
                break;
            }
        }
        if (breakPoint == -1) {
            for (int i = 0; i < nums.length / 2; i++) {
                swap(nums, i, len - i - 1);
            }
            return;
        }

        for (int i = len - 1; i > breakPoint; i--) {
            if (nums[i] > nums[breakPoint]) {
                swap(nums, i, breakPoint);
                break;
            }

        }
        int start = breakPoint + 1;
        int end = len - 1;

        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    static void swap(int[] nums, int one, int two) {
        int temp = nums[one];
        nums[one] = nums[two];
        nums[two] = temp;
    }
}
