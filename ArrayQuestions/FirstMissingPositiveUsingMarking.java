package ArrayQuestions;

public class FirstMissingPositiveUsingMarking {
    public static void main(String[] args) {
        int[] nums = {1,-2,3,4,5,6,7,8,9,10,0,-1,19,20,-23};
        System.out.println(missingPos(nums));
    }
    static int missingPos(int[] nums){
        int n = nums.length;
        int ignore = n + 2;

        for (int i = 0; i < n; i++) {
            if(nums[i] <= 0 ){
                nums[i] = ignore;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1;

            if(index <= n && nums[i] <= n && nums[index] > 0){
                nums[index] *= -1;
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i] >= 0){
                return i + 1;
            }
        }

        return n + 1;
    }
}
