package ArrayQuestions;
/*
passed a very huge test case, but the answer is logically incorrect.
passed 45/90 test cases i think.
 */
public class MinimumOperationstoReduceXtoZero {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int x = 10;
        System.out.println(minOperations(nums, x));
    }
    static int minOperations(int[] nums, int x) {
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        int counter = 0;

        while (pointer1 <= pointer2) {
            if (nums[pointer1] >= nums[pointer2] && nums[pointer1] <= x && x > 0 || nums[pointer2] > x) {
                x -= nums[pointer1];
                pointer1++;
                counter++;
            }
            else if (nums[pointer1] < nums[pointer2] && nums[pointer2] <= x && x > 0 || nums[pointer1] > x) {
                x -= nums[pointer2];
                pointer2--;
                counter++;
            }

            if (nums[pointer2] > x) {
                pointer2--;
            }

            if (nums[pointer1] > x) {
                pointer1++;
            }

            if (x == 0) {
                return counter;
            }
        }
        return -1;
    }
}
