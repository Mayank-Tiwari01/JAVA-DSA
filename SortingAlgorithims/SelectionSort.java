package SortingAlgorithims;
import java.util.Arrays;
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {0,-1,232,1212,222,111,32311,1,1,1,1000};
        System.out.println(Arrays.toString(SelectionSort(nums)));
    }
    static int[] SelectionSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int last = nums.length - 1 - i;
            int max = LargestElement(nums,0,last);
           Swap(nums,last,max);
        }
        return nums;
    }
    static int LargestElement(int[] nums, int start, int end){
        int maxIndex = start;
        int maxElement = Integer.MIN_VALUE;
        for(int i = start; i <= end; i++){
            if(nums[i] > maxElement){
                maxIndex = i;
                maxElement = nums[i];
            }
        }
        return maxIndex;
    }
    static void Swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
