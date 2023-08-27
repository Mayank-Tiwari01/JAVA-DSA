package ArrayQuestions;

public class MaximumProductofThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {-100,-98,-1,2,3,4};
        System.out.println(maxProduct(nums));
    }
    static int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = nums[i];
            }
            else if (nums[i] >= secMax && nums[i] <= firstMax) {
                thirdMax = secMax;
                secMax = nums[i];
            }
            else if (nums[i] >= thirdMax && nums[i] <= firstMax && nums[i] <= secMax) {
                thirdMax = nums[i];
            }

            if (nums[i] <= firstMin) {
                secMin = firstMin;
                firstMin = nums[i];
            }

            else if (nums[i] <= secMin && nums[i] >= firstMin) {
                secMin = nums[i];
            }
        }
        int posMul = firstMax * secMax * thirdMax;
        int negMul = firstMin * secMin * firstMax;

        return Math.max(posMul, negMul);
    }
}
