package Recursion;

import java.util.Arrays;

public class SellingWinesTabulation {
    static int maxCost(int[] wine) {
        int n = wine.length;
        int[][] dp = new int[n][n];

        // base cases
        for (int i = 0; i < n; i++) {
            dp[i][i] = wine[i] * n;
        }

        // bottom-up manner
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                int year = n - (j - i);
                // leftmost bottle
                int cost1 = wine[i] * year + dp[i + 1][j];

                //rightmost bottle
                int cost2 = wine[j] * year + dp[i][j - 1];

                dp[i][j] = Math.max(cost1, cost2);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        // returning top-right cell of the table
        //ans idhr stored hoga, theoretically
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] wine = {2,3,5,1,4};
        System.out.println(maxCost(wine));
    };}
