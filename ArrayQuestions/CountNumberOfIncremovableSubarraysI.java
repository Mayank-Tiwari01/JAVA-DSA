package ArrayQuestions;

class CountNumberOfIncremovableSubarraysI {
    public static void main(String[] args) {
        int[] nums = {6, 5, 7, 8};
        System.out.println(incremovableSubarrayCount(nums));
    }

    static int incremovableSubarrayCount(int[] nums) {
        int length = nums.length;
        int count = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (isIncremovable(i, j, nums)) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isIncremovable(int start, int end, int[] nums) {
        int[] temp = new int[nums.length - (end - start + 1)];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i < start || i > end) {
                temp[index++] = nums[i];
            }
        }

        for (int i = 0; i < temp.length - 1; i++) {
            if (temp[i] >= temp[i + 1]) {
                return false;
            }
        }
        return true;
    }
}