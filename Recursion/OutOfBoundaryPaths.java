package Recursion;

public class OutOfBoundaryPaths {
    public static void main(String[] args) {
        int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
    }
    static  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        return solve(startRow, startColumn, m, n, maxMove);
    }

    static int solve (int row, int col, int m, int n, int cap) {

        // Base Case
        if (row < 0 || row == m|| col < 0 || col == n) {
            return 1;
        }

        if (cap == 0) {
            return 0;
        }


        // Move Up
        int up = solve(row - 1, col, m, n, cap - 1);

        // Move Right
        int right = solve (row, col + 1, m, n, cap - 1);

        // Move Down
        int down = solve(row + 1, col, m, n, cap - 1);

        // Move Left
        int left = solve(row, col - 1, m, n, cap - 1);

        int mod = 1000000007;
        return (up + right + down + left) % mod;
    }
}