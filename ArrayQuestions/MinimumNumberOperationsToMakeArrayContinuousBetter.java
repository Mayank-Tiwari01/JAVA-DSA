package ArrayQuestions;
import java.util.*;
public class MinimumNumberOperationsToMakeArrayContinuousBetter {
    public static void main(String[] args) {
        int[] nums = {41,33,29,33,35,26,47,24,18,28}; //5
    }
    static int minOp(int[] nums) {
        int n = nums.length;
        int ans = n;

        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        int[] newNums = new int[unique.size()];
        int index = 0;

        for (int num : unique) {
            newNums[index++] = num;
        }

        Arrays.sort(newNums);

        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i] + n) {
                j++;
            }

            int count = j - i;
            ans = Math.min(ans, n - count);
        }

        return ans;
    }
}

