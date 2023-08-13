package SortingQuestions;

import java.util.Arrays;
public class SortingColorsWIthConstantSpace {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        //Array will only have 0,1 or 2.
        int numOfZero = 0;
        int numOfOne = 0;
        int numOfTwo = 0;

        for (int num : nums) {
            if (num == 0) {
                numOfZero++;
            } else if (num == 1) {
                numOfOne++;
            } else {
                numOfTwo++;
            }
        }
        int index = 0;
        for(int i = 0; i < numOfZero; i++){
            nums[index] = 0;
            index++;
        }
        for(int i = 0; i < numOfOne; i++){
            nums[index] = 1;
            index++;
        }
        for(int i = 0; i < numOfTwo; i++){
            nums[index] = 2;
            index++;
        }
        System.out.println(Arrays.toString(nums));
    }
}


