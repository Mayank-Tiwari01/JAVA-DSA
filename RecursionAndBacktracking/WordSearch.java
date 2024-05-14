package RecursionAndBacktracking;
//https://www.youtube.com/watch?v=whyax_vB8xY&list=TLPQMjcwMjIwMjTEEyPdzCobIA&index=1
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        StringBuilder str = new StringBuilder(word);
        System.out.println(exist(board, word));
    }
    static boolean exist(char[][] board, String word) {
        //should not make the algo efficient, but it's leetcode, so they design the test cases
        //where they would intentionally change the last char of a test case, if you reverse
        //the string you fight those odds better.

        StringBuilder s = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            s.append(word.charAt(i));
        }
        word = s.toString();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == word.charAt(0) && findWord(board, word, row, col, 0))
                    return true;
            }
        }
        return false;
    }
    static boolean findWord(char[][] board, String word, int row, int col, int idx) {
        if (idx == word.length())
            return true;

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length)
            return false;

        if (board[row][col] == '$'|| board[row][col] != word.charAt(idx))
            return false;

        //Use this to write the four recursive calls more cleanly. Down, left, right and up.
        int[][] movements = {{1,0},{0,-1},{0,1},{-1,0}};

        char temp = board[row][col];
        board[row][col] = '$'; //dollar sign one time, we back, yeah!

        for (int[] move : movements) {
            int newRow = row + move[0];
            int newCol = col + move[1];

            if (findWord(board, word, newRow, newCol, idx + 1))
                return true;
        }

        board[row][col] = temp;

        return false;
    }
}