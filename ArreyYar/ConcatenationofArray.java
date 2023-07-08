package ArreyYar;
import java.util.Arrays;

public class ConcatenationofArray {
    public static void main(String[] args) {
        int[] nums = {1,3,2,1};
        int length = nums.length;
        int[] ans = new int[2 * length];

        for(int i = 0; i < nums.length; i++){
            ans[i] = nums[i];
        }

        for ( int i = 0; i < nums.length ; i++ ){
            ans[nums.length + i ] = nums[i];
        }

        System.out.println(Arrays.toString(ans));

        
    }
}
