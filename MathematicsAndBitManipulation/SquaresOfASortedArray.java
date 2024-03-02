package MathematicsAndBitManipulation;
/*
The logic is that the largest number after squaring would either be the first element or the last element.
Given that the input array is sorted and there may be -ve values.
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] nums = {-12,2,3,67};
    }
    static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int idx = len - 1;
        int start = 0;
        int end = len - 1;

        while (start <= end) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                ans[idx] = nums[start] * nums[start];
                start++;
            }
            else {
                ans[idx] = nums[end] * nums[end];
                end--;
            }
            idx--;
        }
        return ans;
    }
}
