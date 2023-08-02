package BS;

import java.util.Arrays;

public class FindDuplicateElement {
    public static void main(String[] args){
        int[] nums = {3,2,1,4,7,8,12,33,33};
        Arrays.sort(nums);
        System.out.println(DuplicateNum(nums));
    }
    static int DuplicateNum(int[]nums){
        int start = 0;
        int end = 1;

        while(end < nums.length){
            if(nums[start] == nums[end]){
                return nums[start];
            }
            else{
                start++;
                end++;
            }
        }
        return -1;
    }
}
