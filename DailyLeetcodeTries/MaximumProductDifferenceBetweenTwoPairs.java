package DailyLeetcodeTries;
/*
Too easy. Everything OG ofc. Run Time 2ms beats 97.5% of users with java. O(N) and O(1).
A 3-line answer with O(NlogN) complexity is (7ms):
 Arrays.sort(nums);
        int length = nums.length;
        return (nums[length - 1] * nums[length - 2]) - (nums[0] * nums[1]);
 */
public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        int[] nums = {4,2,5,9,7,4,8};
        System.out.println(maxProduct(nums));
    }
    static int maxProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            }
            else if(num <= firstMax && num > secondMax) {
                secondMax = num;
            }
            if (num < firstMin) {
                secondMin = firstMin;
                firstMin = num;
            }
            else if (num < secondMin) {
                secondMin = num;
            }
        }
        return (firstMax * secondMax) - (firstMin * secondMin);
    }
}
