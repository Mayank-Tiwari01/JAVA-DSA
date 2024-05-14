package RecursionAndBacktracking;
import java.util.*;
//the use of row and col at the right place is crucial acc to me, because you do col + 1, means checking in the next col,
//acc to this the isPossible function will change, so use them as they are.
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = solveNQueens(n);
        printResults(result, n);
    }

    static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        //s.append(".".repeat(Math.max(0, n)));
        //s.append(".".repeat(n));
        for (int i = 0; i < n; i++) {
            s.append('.');
        }

        for (int i = 0; i < n; i++) {
            board.add(new StringBuilder(s.toString()));//the only major mistake that I did.
        }
        /*
         If you directly use board.add(s);
         Inside the loop, you will end up with a board where all rows reference the same StringBuilder object,
         and any modification to one row will affect all others. This is because StringBuilder is mutable,
         and adding the same instance to the list multiple times means they all point to the same underlying object.
         (That is why when I added 'Q' at one place, it added in all the StringBuilders present in the board list).
         */
        helper(board, ans, 0, n);

        return ans;
    }

    static void helper(List<StringBuilder> board, List<List<String>> ans, int col, int n) {
        if (col == n) {
            ans.add(toStringList(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isPossible(board, col, row, n)) {
                board.get(row).setCharAt(col, 'Q');
                helper(board, ans, col + 1, n);
                board.get(row).setCharAt(col, '.');
            }
        }
    }

    static boolean isPossible(List<StringBuilder> board, int col, int row, int n) {
        int saveRow = row;
        int saveCol = col;

        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        row = saveRow;
        col = saveCol;

        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        col = saveCol;

        while (row < n && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    static List<String> toStringList(List<StringBuilder> board) {
        List<String> result = new ArrayList<>();
        for (StringBuilder row : board) {
            result.add(row.toString());
        }
        return result;
    }

    static void printResults(List<List<String>> result, int n) {
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            //just for beauty purposes. I have lots of time, I spend it like this.
            while (n + 2 > 0) {
                System.out.print("-");
                n--;
            }
            System.out.println(" ");
        }
    }
}





/*
package Recursion;
import java.util.*;
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
    }
    static List<List<StringBuilder>> solveNQueens(int n) {
        List<List<StringBuilder>> ans = new ArrayList<>();
        List<StringBuilder> board = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        int x = n;
        while (x > 0) {
            s.append('.');
            x--;
        }
        for (int i = 0; i < n; i++) {
            board.add(s);
        }
        helper(board, ans, 0, n);

        return ans;
    }
    static void helper(List<StringBuilder> board, List<List<StringBuilder>> ans, int col, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isPossible(board, col, row, n)) {
                board.get(row).setCharAt(col, 'Q');
                helper(board, ans, col + 1, n);
                board.get(row).setCharAt(col, '.');
            }
        }
    }
    static boolean isPossible(List<StringBuilder> board, int col, int row, int n) {
        int saveRow = row;
        int saveCol = col;

        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row--;
            col--;
        }

        row = saveRow;
        col = saveCol;

        while (col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            col--;
        }

        col = saveCol;
        while (row >= 0 && col >= 0) {
            if (board.get(row).charAt(col) == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
}

 */
