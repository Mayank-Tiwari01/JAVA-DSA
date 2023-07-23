package BS;

public class SearchRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        boolean ans = duplicateInRotatedSorted(nums, target);
        System.out.println(ans);
    }

    static boolean duplicateInRotatedSorted(int[] nums, int target) {
        int start = 0;
        int length = nums.length;
        int end = length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[0] == nums[mid] && nums[mid] == nums[length - 1]) {
                // Handle duplicates at both ends
                start++;
                end--;
            } else if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[length - 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }
}
