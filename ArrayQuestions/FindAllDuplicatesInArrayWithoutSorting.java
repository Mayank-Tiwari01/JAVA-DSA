package ArrayQuestions;

import java.util.ArrayList;

public class FindAllDuplicatesInArrayWithoutSorting {
    public static void main(String[] args) {
        int [] nums = {4,3,2,7,8,2,3,1};
        System.out.println(duplicateNums(nums));
    }
    static ArrayList<Integer> duplicateNums (int[] nums) {
        ArrayList<Integer> duplicateNums = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0) {
                nums[index] *= -1;
            }
            else if(nums[index] < 0) {
                duplicateNums.add(Math.abs(index) + 1);
            }
        }
        return duplicateNums;
    }
}
