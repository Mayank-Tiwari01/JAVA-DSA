package Recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        //https://leetcode.com/problems/sudoku-solver/
    }
    static boolean helper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isPossible(board, i, j, c)) {
                            board[i][j] = c;

                            if (helper(board))
                                return true;

                            else
                                board[i][j] = '.'; //if the value you placed
                            //becomes wrong after some other value is placed.
                        }
                    }
                    return false; //if you could not find anything to place, then return false.
                }
            }
        }
        return true;
    }
    static boolean isPossible(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)
                return false;

            if (board[row][i] == c)
                return false;

            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;
        }
        return true;
    }
}
