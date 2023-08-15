package ArrayQuestions;
//for the most optimal solution see:
//Boyer-Moore Majority Vote Algorithm.

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3,2,3};
        System.out.println(majElement(nums));
    }
    static int majElement(int[] nums){
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            counter = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    counter++;
                }
                if(counter > (nums.length / 2)){
                    return nums[i];
                }
            }

        }
        return -1;
    }
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
 */

//or hashing
