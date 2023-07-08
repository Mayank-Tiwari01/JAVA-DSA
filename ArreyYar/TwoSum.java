package ArreyYar;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15,2};
        int target = 4;
        int[] sol = new int[2];

        for( int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if (nums[i] + nums[j] == target){
                    sol[i] = nums[i];
                    sol[j] = nums[j];
                }
            }
        }
        System.out.println(Arrays.toString(sol));
    }
}
