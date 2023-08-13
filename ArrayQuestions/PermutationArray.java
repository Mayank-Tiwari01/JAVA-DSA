package ArrayQuestions;

import java.util.Arrays;

public class PermutationArray {
    public static void main(String[] args) {

        int[] nums ={0,2,1,5,3,4};
        int[] ans = new int[6];

        for ( int i = 0; i < 6; i++ ){
            ans[i] = nums[nums[i]];
        }
        System.out.println(Arrays.toString(ans));

    }
}
