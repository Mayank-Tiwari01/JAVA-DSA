package SortingQuestions;

public class MissingNumUsingCyclicSort {
    public static void main(String[] args) {
        int[] nums = {9,8,0,6,5,4,3,2,1};
        System.out.println(missingNum(nums));
    }
    static int missingNum(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] < nums.length && nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }
            else{
                i++;
            }
        }
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }
        return nums.length;
    }
    static void swap (int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
