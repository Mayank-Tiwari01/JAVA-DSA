package SortingQuestions;
/*
directly copy pasted from leetcode (kiya maine hi hai)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        cyclicSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return nums[i];
            }
        }
        return -1;
    }
    int[] cyclicSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correctIndex = nums[i];
            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }
            else if(nums[i] == nums[correctIndex]){
                i++;
            }
        }
        return nums;
    }
    void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
