package BS;

public class RotatedBSPartOne {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
        int target = 10;
        System.out.println(BS(nums, target));
    }
    static int BS(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            //if the left part is sorted.
            if(nums[mid] > nums[0] ){
                if(target < nums[mid] && nums[0] < target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            //or the right part of the array is sorted
            else{
                    if(target > nums[mid] && target < nums[nums.length - 1]){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
            }
        }
        return -1;
    }
}
