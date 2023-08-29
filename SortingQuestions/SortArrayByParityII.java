package SortingQuestions;

import java.util.Arrays;

public class SortArrayByParityII {
    public static void main(String[] args) {
        int[] nums = {4,2,5,7,2,3};
        System.out.println(Arrays.toString(sortEvenOdd(nums)));
    }
    static int[] sortEvenOdd (int[] nums) {
        int[] sorted = new int[nums.length];
        int indexEven = 0;
        int indexOdd = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                sorted[indexEven] = nums[i];
                indexEven += 2;
            }
            else {
                sorted[indexOdd] = nums[i];
                indexOdd += 2;
            }
        }
        return sorted;
    }
}
