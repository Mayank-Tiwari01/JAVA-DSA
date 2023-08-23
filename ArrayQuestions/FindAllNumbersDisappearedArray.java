package ArrayQuestions;
import java.util.ArrayList;
/*
This code is correct, but it is too brute force. It will give TLE error.
also the code is pretty basic and i took an hour just implementing it
kind of ashamed of myself. Today is 23 aug 2023.
 */

public class FindAllNumbersDisappearedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,2};
        System.out.println(missingNums(nums));
    }

    static ArrayList<Integer> missingNums(int[] nums) {
        ArrayList<Integer> missingNums = new ArrayList<>();
        int pointer = 0;
        boolean found = false;

        for (int i = 1; i <= nums.length; i++) {
            found = false;
            pointer = 0;
            while(pointer < nums.length){
                if(nums[pointer] != i){
                    pointer++;
                }
                else if(nums[pointer] == i){
                    found = true;
                    break;
                }
            }
            if(!found){
                missingNums.add(i);
            }
        }
        return missingNums;
    }
}
