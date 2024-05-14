package RecursionAndBacktracking;

import java.util.*;
/*
Uses hashing to optimize the checkPossible function.
For left check use a simple array and put 1 at the row, you place a queen
For lower diagonal use a 2n + 1 array and place a 1 at row + col place
For upper diagonal use a 2n + 1 array and place a 1 at n - 1 + col - row place.
Read the code of NQueens too.
 */
public class NQueensOptimal {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        System.out.println(result);
    }
    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append('.');
        }
        for (int j = 0; j < n; j++) {
            board.add(new StringBuilder(str));
        }
        int[] checkLeft = new int[n + 1];
        int[] checkLowerDiagonal = new int[2 * n + 1];
        int[] checkUpperDiagonal = new int[2 * n + 1];
        int col = 0;

        helper(ans, board, checkLeft, checkLowerDiagonal, checkUpperDiagonal, col, n);
        return ans;
    }
    static void helper(List<List<String>> ans, List<StringBuilder> board, int[] checkLeft, int[] checkLowerDiagonal, int[] checkUpperDiagonal, int col, int n) {
        if (col == n) {
            ans.add(makeString(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (checkLeft[row] == 0 && checkLowerDiagonal[row + col] == 0 && checkUpperDiagonal[n - 1 + col - row] == 0) {
                board.get(row).setCharAt(col, 'Q');
                checkLeft[row] = 1;
                checkLowerDiagonal[row + col] = 1;
                checkUpperDiagonal[n - 1 + col - row] = 1;

                helper(ans, board, checkLeft, checkLowerDiagonal, checkUpperDiagonal, col + 1, n);

                board.get(row).setCharAt(col, '.');
                checkLeft[row] = 0;
                checkLowerDiagonal[row + col] = 0;
                checkUpperDiagonal[n - 1 + col - row] = 0;
            }
        }
    }
    static List<String> makeString (List<StringBuilder> board) {
        List<String> ans = new ArrayList<>();

        for (StringBuilder row : board) {
            ans.add(row.toString());
        }
        return ans;
    }
}