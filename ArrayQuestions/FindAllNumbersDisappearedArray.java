package ArrayQuestions;
import java.util.ArrayList;
public class FindAllNumbersDisappearedArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(missingNums(nums));
    }
    static ArrayList<Integer> missingNums(int[] nums){
        ArrayList<Integer> missingNums = new ArrayList<>();
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= nums.length; i++){
                if(nums[j] == i){
                    break;
                }
                if(nums[j] != i){
                    j++;
                }
                if(nums[j] != i && j == nums.length - 1){
                    missingNums.add(i);
                }
            }

        }
        return missingNums;
    }
}
