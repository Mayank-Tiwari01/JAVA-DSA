package BS;

public class SearchRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 13;
        boolean ans = DuplicateInRotatedSorted(nums, target);
        System.out.println(ans);
    }
    static boolean DuplicateInRotatedSorted(int[]nums, int target){
        int start = 0;
        int length = nums.length;
        int end = length - 1;


        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                start++;
                end--;
                continue;
            }
            if(nums[start] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}
