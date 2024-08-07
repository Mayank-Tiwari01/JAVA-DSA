package SortingAlgorithims;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.printf(Arrays.toString(cyclicSort(nums)));
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
