package ArreyYar;

import java.util.Arrays;

public class RotateArrayOptimal {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 3;
        int length = nums.length;
        k = k % length;

        Reverse(nums,0, length - 1);
        Reverse(nums, 0, k-1);
        Reverse(nums, k, length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void Reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
