package ArrayQuestions;
import java.util.Arrays;

public class RearrangeArrayElementsbySign {
    public static void main(String[] args){
        int[] nums = {3,1,-2,-5,2,-4};
        //ans = 3,-2,1,-5,2,-4;
        System.out.println(Arrays.toString(rearrange(nums)));
    }
    static int[] rearrange(int[] nums){
        int[] ans = new int[nums.length];
        int indexEven = 0;
        int indexOdd = 1;
        for(int num : nums){
            if(num > 0 && indexEven < nums.length){
                ans[indexEven] = num;
                indexEven += 2;
            }
            if(num < 0 && indexOdd < nums.length){
                ans[indexOdd] = num;
                indexOdd += 2;
            }
        }
        return ans;
    }
}
