package ArrayQuestions;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {-1,-1,1};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }
    static int subarraySum (int[] nums, int k) {
        int sum = 0;
        int subArr = 0;
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                counter++;
            }
            sum += nums[i];
            nums[i] = sum;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (i == 0) {
                    subArr = nums[j];
                    if (subArr == k) {
                        counter++;
                    }
                }
                else {
                    subArr = nums[j] - nums[i - 1];
                    if (subArr == k) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}

