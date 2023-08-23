package SortingQuestions;

import java.util.Arrays;

/*
a much better solution involving markings is in array questions folder
 */
public class SetMismatchCyclic {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,7,9,10};
        System.out.println(Arrays.toString(setMismatch(nums)));
    }
    static int[] setMismatch(int[] nums) {
        int[] setMismatch = new int[2];
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            if(i != index){
                setMismatch[0] = nums[i];
                setMismatch[1] = i + 1;
            }

        }
        return  setMismatch;
    }
    static int[] cyclicSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }
            else if(nums[i] == nums[correctIndex]){
                i++;
            }
        }
        return nums;
    }
    static void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
