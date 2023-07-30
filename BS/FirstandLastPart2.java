package BS;

import java.util.Arrays;

public class FirstandLastPart2 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,43,32,4,4,1};
        int target = 4;
        int[] ans = ans( nums, target);
        System.out.println(Arrays.toString(ans));
        
    }
    static int[] ans(int[] nums, int target){
        int[] ans = {-1,-1};
        ans[0] = index(nums,target,true);
        ans[1] = index(nums,target,false);
        return ans;
    }
    static int index(int[] nums, int target, boolean isFirstIndex){
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else if(nums[mid] > target){
                end = mid - 1;
            }
            else{
                ans = mid;
                if(isFirstIndex){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
