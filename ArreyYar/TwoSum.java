package ArreyYar;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        int[] sol = new int[2];

        for( int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length ; j++){
                if (nums[i] + nums[j] == target){
                    sol[1] = i;
                    sol[0] = j;                    
                }
            }
        }
        System.out.println(Arrays.toString(sol));
        
    }
}
