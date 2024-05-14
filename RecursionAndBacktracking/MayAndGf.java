package RecursionAndBacktracking;

import java.util.Arrays;

public class MayAndGf {

    static int maxFallingPathSum(int[][] A, int[][] memo, int S1, int S2, int F1, int F2) {
        if (F1 == S1 && F2 == S2) return A[S1][S2];
        if (F1 < S1 || F2 < S2) return Integer.MIN_VALUE;
        if (memo[F1][F2] != -1) return memo[F1][F2];

        return memo[F1][F2] = A[F1][F2] + Math.max(
                maxFallingPathSum(A, memo, S1, S2, F1 - 1, F2),
                maxFallingPathSum(A, memo, S1, S2, F1, F2 - 1)
        );
    }

    static int maxRisingPathSum(int[][] A, int[][] memo, int Si, int Sj, int Fi, int Fj) {
        if (Fi == Si && Fj == Sj) return A[Si][Sj];
        if (Fi > Si || Fj < Sj) return Integer.MIN_VALUE;
        if (memo[Fi][Fj] != -1) return memo[Fi][Fj];

        return memo[Fi][Fj] = A[Fi][Fj] + Math.max(
                maxRisingPathSum(A, memo, Si, Sj, Fi + 1, Fj),
                maxRisingPathSum(A, memo, Si, Sj, Fi, Fj - 1)
        );
    }

    static int solve(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        int ans = 0;

        //  memoization outside the inner loop
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                // Boy (vertical)
                int X = maxFallingPathSum(A, memo, 0, 0, i - 1, j);
                X += maxFallingPathSum(A, memo, i + 1, j, m - 1, n - 1);

                // Girl (horizontal)
                X += maxRisingPathSum(A, memo, m - 1, 0, i, j - 1);
                X += maxRisingPathSum(A, memo, i, j + 1, 0, n - 1);

                // Reset memoization for the next iteration
                Arrays.fill(memo[0], -1);
                Arrays.fill(memo[m - 1], -1);

                // Boy (horizontal)
                int Y = maxFallingPathSum(A, memo, 0, 0, i, j - 1);
                Y += maxFallingPathSum(A, memo, i, j + 1, m - 1, n - 1);

                // Girl (vertical)
                Y += maxRisingPathSum(A, memo, m - 1, 0, i + 1, j);
                Y += maxRisingPathSum(A, memo, i - 1, j, 0, n - 1);

                ans = Math.max(ans, Math.max(X, Y));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 1, 4, 6},
                {6, 8, 7, -2, 3},
                {4, 3, 2, 1, 6},
                {11, 10, 8, 5, 4},
                {12, 15, 6, 3, 7},
        };

        System.out.println(solve(A));
    }
}
