package ArreyYar;

import java.util.Arrays;

public class RotateArray {
   public static void main(String[] args) {
    
    int [] nums = {9,2,2,2,2,2,1,1,1,1,1,1,1,1,32,1,33,21};
    int k = 3;
    int length = nums.length;
    k = k % length; 
    int [] ans = new int[length];
    int j = 0;
    
    for (int i = length - k; i < length; i++){
        ans[j] = nums[i];
        j++;
    }

    System.out.println(Arrays.toString(ans));
    
    int l = 0;
    for(int i = k; i < length ; i++){
        ans[i] = nums[l];
        l++;
       
    }

    System.out.println(Arrays.toString(ans));

   } 
}
