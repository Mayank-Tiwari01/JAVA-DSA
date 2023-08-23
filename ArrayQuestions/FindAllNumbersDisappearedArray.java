package ArrayQuestions;
import java.util.ArrayList;
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
