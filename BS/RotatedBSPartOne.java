package BS;

public class RotatedBSPartOne {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int target = 5;
    }
    static int BS(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target && nums[0] < nums[mid]){
                end = mid -1;
            }
            else if(nums[mid] > target && nums[0] > nums[mid]){

            }
            else if(nums[mid] < target && nums[mid] < nums[nums.length - 1]){
                start = mid + 1;
            }
        }
    }
}
