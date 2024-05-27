package BS;
import java.util.Arrays;
public class SpecialArrayWithXElementsGreaterThanOrEqualX {

    private int specialArray0(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if (isX(nums, i))
                return i;
        }
        return -1;
    }
    static boolean isX(int[] nums, int x) {
        int start = 0, end = nums.length - 1;
        int xIdx = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] >= x) {
                xIdx = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }

        return ((nums.length - xIdx) == x);
    }
    static int specialArray(int[] nums) {
        int[] count = new int[nums.length + 1];

        for (int i : nums) {
            if (i > nums.length)
                count[nums.length]++;
            else
                count[i]++;
        }
        int prevCount = 0;

        for (int i = 0; i < nums.length + 1; i++) {
            if (i == (nums.length - prevCount) && i != 0) {
                return i;
            }
            prevCount += count[i];
        }
        return -1;
    }

}
