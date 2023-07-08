package ArreyYar;

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        
    
    int[][] nums = {
        {1,5},
        {7,3},
        {3,5} 
    };
    
    int length = nums.length;
    int[] sum = new int[length];
    

    for ( int row = 0; row < length; row++){
        for(int col = 0; col < nums[row].length ; col++){
            sum[row] += nums[row][col];         
        }
    }

    int largest = sum[0];

    for ( int i = 0; i < length; i++){
        if(sum[i] > largest){
            largest = sum[i];
        }
    }

    System.out.println(Arrays.toString(sum));
    System.out.println(largest);
}

}
