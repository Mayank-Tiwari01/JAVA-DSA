package BS;

public class SplitArrayLargestSum {
    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int k = 2;
        int ans = LargestSum(nums, k);
        System.out.println(ans);
    }
    public static int upperLimit(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max += nums[i];
        }
        return max;
    }
    public static int lowerLimit(int[] nums){
        int highest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > highest){
                highest = nums[i];
            }
        }
        return highest;
    }
    public static int LargestSum(int[] nums, int k){
        int end = upperLimit(nums);
        int start = lowerLimit(nums);

        while(start < end){
            int mid = start + (end - start) / 2;
            int pieces = 1;
            int sum = 0;

            for(int num : nums){
                if(num + sum > mid){
                    sum = num;
                    pieces++;
                }
                else{
                    sum += num;
                }
            }
            if(pieces > k){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return end;
    }
}
