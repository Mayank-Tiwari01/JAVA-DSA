package ArreyYar;
import java.util.Arrays;
public class Unique {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int length = nums.length;
        int[] uniqueArrayFrequency = new int[length];
        int freq = 0;

        for (int i = 0; i < length; i++){
            for (int j = 0; j < length ; j++){
                if(nums[i] == nums[j]){
                    freq++;
                }
            }
            uniqueArrayFrequency[i] = freq;
            freq = 0;
        }

        int numOfUnique = 0;

        for (int i = 0; i < length; i++){
            if(uniqueArrayFrequency[i] == 1){
                numOfUnique++;
            }
        }

        System.out.println(Arrays.toString(uniqueArrayFrequency));
        System.out.println(numOfUnique);
    }

}
