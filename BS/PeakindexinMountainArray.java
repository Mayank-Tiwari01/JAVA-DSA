package BS;

public class PeakindexinMountainArray {
    public static void main(String[] args) {
        int [] nums = {0,10,5,2};
        int ans = ans(nums);
        System.out.println(ans);
    }
    static int ans(int[] nums) {
        int start = 0;
        int end = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[end] < nums[start]) {
                return start;
            }
            start++;
            end++;
        }
        return -1;
    }
}
