package BS;

public class SplitArrayLargestSum {
    public static void main(String[] args){
        int[] nums = {7,2,5,10,8};
        int k = 2;
        int max = upperLimit(nums);
        System.out.println(max);
    }
    static int upperLimit(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max += nums[i];
        }
        return max;
    }
}
