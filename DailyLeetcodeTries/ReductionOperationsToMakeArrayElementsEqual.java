package DailyLeetcodeTries;

import java.util.Arrays;
/*
Runtime: 34 ms Beats 81.58% of users with Java
did it all by myself, from intuition to approach to execution to thought everything
The only good thing that happened today I guess, yes the date is 19th dec :)
 */
public class ReductionOperationsToMakeArrayElementsEqual {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,2,2,2,2,4,4,4,4,5};
        System.out.println(operationReq(nums));
    }
    static int operationReq(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                count += length - (i + 1);
            }
        }
        return count;
    }
}
