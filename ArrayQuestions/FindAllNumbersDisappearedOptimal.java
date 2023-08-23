package ArrayQuestions;

import java.util.ArrayList;

public class FindAllNumbersDisappearedOptimal {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(missingNums(nums));
    }
    static ArrayList<Integer> missingNums(int[] nums){
        ArrayList<Integer> missingNums = new ArrayList<>();
        for(int num : nums){
            int index = Math.abs(num) - 1;
            if(nums[index] > 0){
                nums[index] *= -1;
            }
        }
        for(int num = 0; num < nums.length; num++){
            if(nums[num] > 0){
                missingNums.add(num + 1);
            }
        }
        return missingNums;
    }
}
