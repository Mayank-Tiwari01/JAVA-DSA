package ArreyYar;
import java.util.Arrays;
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,0,1,2,3,34,0,0,0};
        int length = nums.length;
        int CountZeroes = 0;

        for (int i = 0; i < length; i++){
            if (nums[i] == 0){
                CountZeroes++;
            }
        }
        int j = 0;
        for (int i = 0; i < length; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }

        for (int i = length - CountZeroes; i < length; i++){
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
