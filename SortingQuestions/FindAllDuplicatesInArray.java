package SortingQuestions;

import java.util.ArrayList;

public class FindAllDuplicatesInArray {
    public static void main(String[] args) {
        int [] nums = {2, 5, 2, 1, 1, 4};
        System.out.println(duplicateNums(nums));
    }
    static ArrayList<Integer> duplicateNums (int[] nums) {
        ArrayList<Integer> duplicateNums = new ArrayList<>();
        cyclicSort(nums);

        for(int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            if(i != index){
                duplicateNums.add(nums[i]);
            }
        }
        return duplicateNums;
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
