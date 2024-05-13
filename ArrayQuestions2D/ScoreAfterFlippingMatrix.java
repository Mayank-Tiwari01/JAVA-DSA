package ArrayQuestions2D;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] grid = {{1}};
    }
    static int matrixScore(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            if (grid[i][0] == 1)
                flipBits(grid, i, 0, true);
        }
        for (int i = 0; i < colLen; i++) {
            int countZero = 0;
            int countOne = 0;
            for (int j = 0; j < rowLen; j++) {
                if (grid[j][i] == 0)
                    countZero++;
                else
                    countOne++;
            }
            if (countOne < countZero)
                flipBits(grid, 0, i, false);
        }
        int sum = 0;
        for (int i = 0; i < rowLen; i++) {
            int power = (int) Math.pow(2, colLen - 1);
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1)
                    sum += power;

                power /= 2;
            }
        }

        return sum;
    }
    static void flipBits(int[][] grid, int row, int col, boolean isRow) {
        if (isRow) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[row][i] == 0)
                    grid[row][i] = 1;
                else
                    grid[row][i] = 0;
            }
        }
        else {
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][col] == 0)
                    grid[i][col] = 1;
                else
                    grid[i][col] = 0;
            }
        }
    }
}
