package SortingQuestions;

import java.util.Arrays;

public class DNF {
    public static void main(String[] args){
        // watch Striver's video again to understand the thought behind the logic.
        int[] nums = {2,1,2,1,1,1,1,1,2,2,2,0,0,0,1};
        //pointers
        int start = 0;
        int current = 0;
        int end = nums.length - 1;

        while(current <= end){
            if(nums[current] == 0){
                int temp = nums[start];
                nums[start] = nums[current];
                nums[current] = temp;
                start++;
                current++;
            }
            else if(nums[current] == 1){
                current++;
            }
            else{
                int temp = nums[end];
                nums[end] = nums[current];
                nums[current] = temp;
                end--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
