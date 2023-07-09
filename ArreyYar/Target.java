package ArreyYar;

import java.util.Arrays;

public class Target {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] targetArray = new int[5];

        for(int i = 0, j= 0; i < 5; i++){
            if( i >= index[i]){
                targetArray[i] = nums[j++];
            }
            else{
                targetArray[index[i]] = nums[i];
            }
        }
        System.out.println(Arrays.toString(targetArray));
    } 
}
