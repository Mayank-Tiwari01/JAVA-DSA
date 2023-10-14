package SortingQuestions;

import java.util.Arrays;

public class SingleNumberIIIBySorting {
    public static void main(String[] args) {
        int[] nums = {11,44,44,11,99,7,7,8,12,8};
        System.out.println(Arrays.toString(singleNums(nums)));
    }
    static int[] singleNums(int[] nums) {
        Arrays.sort(nums);
        //it is given that there will be only two single values.
        int[] ans = new int[2];
        int index = 0;

        if (nums[0] != nums[1]) {
            ans[index] = nums[0];
            index++;
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            ans[index] = nums[nums.length - 1];
            index++;
        }
        for (int i = 1; i <= nums.length - 2; i++) { //or length - 1. same thing.
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                ans[index] = nums[i];
                index++;
            }
        }
        return ans;
    }
}
