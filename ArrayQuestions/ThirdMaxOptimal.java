package ArrayQuestions;

public class ThirdMaxOptimal {
    public static void main(String[] args) {
        int[] nums = {88,88,88,87,6567,4};
        System.out.println(thirdMax(nums));
    }
    static int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = nums[i];
            }
            else if (nums[i] > secMax && nums[i] < firstMax) {
                thirdMax = secMax;
                secMax = nums[i];
            }
            else if (nums[i] > thirdMax && nums[i] < firstMax && nums[i] < secMax) {
                thirdMax = nums[i];
            }
        }

        if (thirdMax != Long.MIN_VALUE) {
            return (int) thirdMax;
        }
        return (int) firstMax;
    }
}
