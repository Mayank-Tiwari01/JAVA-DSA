package ArrayQuestions;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }
    static int missingNumber(int[] nums){
        int sum = 0;
        int length = nums.length;
        int expectedSum = ( length * (length + 1) ) / 2;
        for(int num : nums) {
            sum += num;
        }
        return expectedSum - sum;
    }
}
