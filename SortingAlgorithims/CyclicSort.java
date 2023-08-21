package SortingAlgorithims;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {29,30,20,1,2,11,35,12,13,26,27,28,14,3,4,10,5,6,7,8,15,16,17,9,18,19,31,32,33,34,21,22,23,24,25};
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
