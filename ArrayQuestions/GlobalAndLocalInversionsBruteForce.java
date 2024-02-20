package ArrayQuestions;
//similar to count inversions (see recursions folder).
public class GlobalAndLocalInversionsBruteForce {
    public static void main(String[] args) {
        int[] nums = {0,2,1};
    }
    static boolean isIdealPermutation(int[] nums) {
        int localInversion = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                localInversion++;
            }
        }
        int globalInversion = mergeSort(nums, 0, nums.length - 1);

        return globalInversion == localInversion;
    }
    static int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start >= end) return count;

        int mid = start + (end - start) / 2;

        count += mergeSort(nums, start, mid);
        count += mergeSort(nums, mid + 1, end);

        count += mergeArrays(nums, start, mid, end);

        return count;
    }
    static int mergeArrays(int[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1;
        int count = 0;
        int[] temp = new int[end - start + 1];
        int idx = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j])
                temp[idx++] = nums[i++];
            else {
                count += mid - i + 1;
                temp[idx++] = nums[j++];
            }
        }

        while (i <= mid) temp[idx++] = nums[i++];
        while (j <= end)  temp[idx++] = nums[j++];

        idx = 0;

        for (int num = start; num <= end; num++) {
            nums[num] = temp[idx++];
        }
        return count;
    }

}
