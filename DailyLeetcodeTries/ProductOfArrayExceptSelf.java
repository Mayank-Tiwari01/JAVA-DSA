package DailyLeetcodeTries;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    static int[] productExceptSelf(int[] nums) {
        long pro = 1;
        //what if there is a zero pagal.
        for (int num : nums) pro *= num;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) pro / nums[i];
        }
        return nums;
    }
}
