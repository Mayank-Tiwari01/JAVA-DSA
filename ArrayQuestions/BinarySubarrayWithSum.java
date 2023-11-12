package ArrayQuestions;
//don't know if my logic was incorrect or not, but I could not even implement what I thought. What a shame.
public class BinarySubarrayWithSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,0,0,0,1,1,1,1,0};
        int target = 3;
        System.out.println(numOfSubArr(nums, target));
    }
    static int numOfSubArr(int[] nums, int goal) {
        if (nums.length == 1) {
            if (nums[0] == goal) {
                return 1;
            }
        }
        int sum = 0, right = 0, left = 0, count = 0, length = nums.length;
        while (left < length - goal) {
            if (right < length && sum < goal) {
                sum += nums[right];
                right ++;
            }
            if ( sum == goal) {
                count++;
                if (right < length) {
                    sum += nums[right];
                    right ++;
                }
            }
            if (sum > goal ) {
                sum -= nums[left];
                left++;
                if (sum > goal) {
                    count++;
                }
            }
            if (sum == goal && right >= length - 1) {
                left++;
            }
        }
        return count;
    }
}
