package ArrayQuestions;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(MaxSubSum(nums));
    }
    static int MaxSubSum(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : nums){
            sum += num;
            if(sum > max){
                max = sum;
            }
            else if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
