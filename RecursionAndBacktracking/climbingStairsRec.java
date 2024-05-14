package RecursionAndBacktracking;

import java.util.Arrays;
//uses dp to remember the past. class.
public class climbingStairsRec {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(countWays(n, dp));
    }
    static int countWays(int n, int[] dp) {
        if (n <= 1)
            return dp[n] = 1;

        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp);
        return dp[n];
    }
}
