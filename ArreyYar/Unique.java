package ArreyYar;
import java.util.Arrays;
public class Unique {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = nums.length;
        int[] uniqueArrayFrequency = new int[length];
        int freq = 0;

        for (int i = 0; i < length; i++){
            for (int j = 1; j < length; j++){
                if(nums[i] == nums[j]){
                    freq++;
                }
            }
        }

        System.out.println(Arrays.toString(uniqueArray));  
    }

}
