package SortingQuestions;

import java.util.*;
/*
3ms
Beats 78.52%of users with Java
 */

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        System.out.println(thirdMax(nums));
    }
    static int thirdMax (int[] nums) {
        Arrays.sort(nums);
        int count = 1;

        int pointerLast = nums.length - 1;
        int pointerSecondLast = pointerLast - 1;

        while (pointerSecondLast >= 0) {
            if (nums[pointerLast] != nums[pointerSecondLast]) {
                count++;
            }
            if (count == 3) {
                return nums[pointerSecondLast];
            }
            pointerLast--;
            pointerSecondLast--;
        }
        return nums[nums.length - 1];
    }
}
