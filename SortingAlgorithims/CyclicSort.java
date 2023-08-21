package SortingAlgorithims;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = {10,9,8,7,6,5,4,3,2,1};
        System.out.printf(Arrays.toString(cyclicSort(nums)));
    }
    static int[] cyclicSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i-1){
                Swap(nums, i, nums[i] - 1);
            }
            else if(nums[i] == i-1){
                break;
            }
        }
        return nums;
    }
    static void Swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
