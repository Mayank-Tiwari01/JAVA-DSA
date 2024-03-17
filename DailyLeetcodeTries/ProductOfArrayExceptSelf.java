package DailyLeetcodeTries;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }
    static int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int pro = 1;
        for (int i : nums) {
            if (i != 0)
                pro *= i;
            else
                zeroCount++;
            if (zeroCount > 1)
                return new int[nums.length];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount == 1 && nums[i] != 0) {
                ans[i] = 0;
            }
            else if (zeroCount == 1 && nums[i] == 0) {
                ans[i] = pro;
            }
            else if (zeroCount == 0) {
                //yeah, not allowed to do that.
                ans[i] = pro / nums[i];
            }
        }
        return ans;
    }
    //without using the div operation.
    static  int[] productExceptSelf2(int[] nums) {
        int len = nums.length;
        int[] prePro = new int[len + 1];
        int idx = 1;
        int[] suffPro = new int[len + 1];
        int idxSuff = len - 1;
        prePro[0] = 1;
        suffPro[len] = 1;
        int zeroCount = 0;
        int pro = 1;
        int pro2 = 1;


        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                pro *= nums[i];
                prePro[idx++] = pro;
            }
            else if (nums[i] == 0) {
                zeroCount++;
                if (zeroCount > 1) return new int[len];
            }
            //if there is even one zero, then we will anyway not use the extra arrays
            pro2 *= nums[len - i - 1];
            suffPro[idxSuff--] = pro2;
        }
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            if (zeroCount == 1 && nums[i] != 0) {
                ans[i] = 0;
            }
            else if (zeroCount == 1 && nums[i] == 0) {
                ans[i] = pro;
            }
            else if (zeroCount == 0) {
                ans[i] = prePro[i] * suffPro[i + 1];
            }
        }
        return ans;
    }
}