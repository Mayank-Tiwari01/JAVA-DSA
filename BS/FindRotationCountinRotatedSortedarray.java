package BS;
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class FindRotationCountinRotatedSortedarray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int ans = Count(nums);
        System.out.println(nums[ans + 1]);
    }

    static int Count(int[] nums) {
        int start = 0;
        int length = nums.length;
        int end = length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (mid > start && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
            if (nums[start] >= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

