package ArrayQuestions;
//if a subarrays product is less than k, then the individual would be less than k too.
public class SubarrayProductLessThanK {
    public static void main(String[] args) {

    }
    static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int len = nums.length;
        int start = 0, pro = 1, count = 0;

        for (int end = 0; end < len; end++) {
            pro *= nums[end];
            while (pro >= k) {
                pro /= nums[start];
                start++;
            }
            count += end - start + 1;
        }
        return count;
    }
}
