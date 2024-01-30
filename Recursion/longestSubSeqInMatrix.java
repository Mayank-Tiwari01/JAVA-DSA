package Recursion;
//class
import java.util.Arrays;

public class longestSubSeqInMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {3,2,0,100},
                {4,1,6,7},
                {8,11,2,3},
                {10,7,24,4},
                {9,12,5,23},
        };
        int n = 4, m = 5;
        System.out.println(wrapper(mat, n, m));
    }

    static int LIP(int[][] dp, int[][] mat, int n,
                   int m, int x, int y) {
        // If value not calculated yet.
        if (dp[x][y] < 0) {
            int result = 0;

            // If reach bottom right cell, return 1.
            if (x == n - 1 && y == m - 1)
                return dp[x][y] = 1;

            // If reach the corner of the matrix.
            if (x == n - 1 || y == m - 1)
                result = 1;

            // If value greater than below cell.
            if (x + 1 < n && mat[x][y] < mat[x + 1][y])
                result = 1 + LIP(dp, mat, n, m, x + 1, y);

            // If value greater than left cell.
            if (y + 1 < m && mat[x][y] < mat[x][y + 1])
                result = Math.max(result, 1 + LIP(dp, mat, n, m, x, y + 1));

            dp[x][y] = result;
        }

        return dp[x][y];
    }


    static int wrapper(int[][] mat, int n, int m) {
        int[][] dp = new int[10][10];
        for (int i = 0; i < 10; i++)
            Arrays.fill(dp[i], -1);

        return LIP(dp, mat, n, m, 0, 0);
    }
}