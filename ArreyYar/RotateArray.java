package ArreyYar;

import java.util.Arrays;

public class RotateArray {
   public static void main(String[] args) {
    
    int [] nums = {-1,-100,3,99};
    int k = 2;
    int length = nums.length;
    int [] ans = new int[length];
    int j = 0;
    
    for (int i = k; i < length; i++){
        ans[j] = nums[i];
        j++;
    }

    System.out.println(Arrays.toString(ans));
    int l = k;

    for(int i = 0; i < k+1; i++){
        ans[l] = nums[i];
        l++;
    }
    System.out.println(Arrays.toString(ans));

   } 
}
