package ArrayQuestions;

import java.util.Arrays;
/*
math.abs is imp
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,7,9,10};
        System.out.println(Arrays.toString(setMismatch(nums)));
    }
    static int[] setMismatch(int[] nums) {
        int[] setMismatch = new int[2];

        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
            else{
                setMismatch[0] = index + 1;
            }
        }

        for (int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                setMismatch[1] = i + 1;
                break;
            }
        }
        return setMismatch;
    }
}
