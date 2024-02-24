package SortingQuestions;
import java.util.*;
//we have to only deal with the max and the min and also sorting will not mess with it.
public class NumberOfSubsequencesThatSatisfyGivenSumCondition {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        int target = 16;
        System.out.println(numSubseq(nums, target));
    }
    static int numSubseq(int[] nums, int target) {
        int[] pow = new int[nums.length];
        int mod = 1000000007;
        pow[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        Arrays.sort(nums);
        int first = 0;
        int last = nums.length - 1;
        int sum = 0;
        while (first <= last) {
            if (nums[first] + nums[last] <= target) {
                sum = (sum % mod + pow[last - first]) % mod;
                first++;
            }
            else {
                last--;
            }
        }
        return sum;
    }
}
