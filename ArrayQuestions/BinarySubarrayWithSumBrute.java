package ArrayQuestions;
/*
Runtime
1641ms
Beats 10.74%of users with Java
 */
public class BinarySubarrayWithSumBrute {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,0,0,0,1,1,1,1,0};
        int target = 3;
        System.out.println(numOfSubArr(nums, target));
    }
    static int numOfSubArr(int[] nums, int goal) {
        int sum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
                if (sum >  goal) {
                    break;
                }
            }
        }
        return count;
    }
}


