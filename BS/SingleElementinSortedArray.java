package BS;

import java.util.Arrays;

public class SingleElementinSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 5};
        System.out.println(SingleElement(nums));
    }
    static int SingleElement(int[]nums){
        int length = nums.length;
        if(length == 1 || nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[length - 1] != nums[length - 2]){
            return nums[length - 1];
        }
        int start = 1;
        int end = length - 2;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]){
                return nums[mid];
            }
            else{
                if(nums[mid] == nums[mid + 1] && mid % 2 == 0 || nums[mid] == nums[mid - 1] && (mid - 1) % 2 == 0){
                    start = mid + 1;
                }
                if(nums[mid] == nums[mid - 1] && (mid -1) % 2 != 0 || nums[mid] == nums[mid + 1] && (mid + 1) % 2 == 0){
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
