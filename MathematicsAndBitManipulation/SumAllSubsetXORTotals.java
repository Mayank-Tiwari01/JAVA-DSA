package MathematicsAndBitManipulation;

public class SumAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {5, 1, 6};
        System.out.println(subsetXORSum(nums));
    }
    static int subsetXORSum(int[] nums) {
        int[] sum = new int[1];
        helper(nums, sum, new int[nums.length], 0);
        return sum[0];
    }
    static void helper(int[] nums, int[] sum, int[] newNums, int i) {
        if (i == nums.length) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                if (newNums[j] != 1)
                    temp = temp ^ nums[j];
            }
            sum[0] += temp;
            return;
        }

        newNums[i] = 1;
        helper(nums, sum, newNums, i + 1);
        newNums[i] = 0;
        helper(nums, sum, newNums, i + 1);
    }
    static  int helperOptimal(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        // Include the current element in the subset
        int include = helperOptimal(nums, index + 1, currentXOR ^ nums[index]);
        // Exclude the current element from the subset
        int exclude = helperOptimal(nums, index + 1, currentXOR);
        // Return the sum of both cases
        return include + exclude;
    }
}
