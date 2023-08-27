package SortingQuestions;

import java.util.Arrays;

/*
very bad complexity, only for educational purposes.
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {12,11,10,9,8,7,6,5,4,3,2,1,12};
        System.out.println(duplicate(nums));
    }
    static boolean duplicate (int[] nums) {
        insertionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
    static void insertionSort (int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            // i is the index where the array is sorted.
            for (int j = i + 1; j > 0; j--) {
                if (j < nums.length && nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
                else {
                    break;
                }
            }
        }
    }
}
