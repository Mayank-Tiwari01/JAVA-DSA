package SortingQuestions;

import java.util.Arrays;
/*
It is not an optimal solution, did it just to implement all the possible solutions.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(missingPositive(nums));
    }
    static int missingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int firstPos = 1;

        for (int i = 0; i < n; i++) {

            if (nums[i] > firstPos){
                return firstPos;
            }

            if (nums[i] == firstPos){
                firstPos++;
            }
        }
        return firstPos;
    }
}
