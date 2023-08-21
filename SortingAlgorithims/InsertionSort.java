package SortingAlgorithims;

import java.util.Arrays;
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {21,18,61,31,101,12,10001,0,1,-1};
        System.out.println(Arrays.toString(SelectionSort(nums)));
    }
    static int[] SelectionSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            //increases the index by 1
            for(int j = 1 + i; j > 0; j--){
                //sorts up till that index
                if(nums[j] < nums[j-1]){
                    Swap(nums, j, j-1);
                }
                else{
                    break;
                }
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

