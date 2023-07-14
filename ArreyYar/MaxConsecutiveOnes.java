package ArreyYar;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = new int[3];
        int count = 0;
        ArrayList<Integer> ones = new ArrayList<>();
        int j = 0;

        for (int i = 1; i <= 3; i++){
            nums[j] = i;
            j++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
