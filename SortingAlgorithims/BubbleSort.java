package SortingAlgorithims;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {10, 90, 30, 40, 50, 60, 70, 80, 20};
        BubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    static int[] BubbleSort(int[] nums) {
        int length = nums.length;
        boolean swapped;

        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i; j++) {
                if (j + 1 < length && nums[j] > nums[j + 1] ) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return nums;
    }
}

