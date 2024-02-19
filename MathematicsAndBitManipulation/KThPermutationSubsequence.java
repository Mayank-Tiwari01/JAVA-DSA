package MathematicsAndBitManipulation;
import java.util.*;
public class KThPermutationSubsequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 17;
    }
    static String getPermutation(int n, int k) {
        ArrayList<Integer>nums = new ArrayList<>();
        int fact = 1;

        for (int i = 1; i < n; i++) {
            fact *= i;
            nums.add(i);
        }
        nums.add(n);
        StringBuilder ans = new StringBuilder();
        k--;
        while (true) {
            ans.append(nums.get(k / fact));
            nums.remove(k / fact);

            if (nums.size() == 0) break;
            k %= fact;
            fact /= nums.size();
        }
        return ans.toString();
    }

}
