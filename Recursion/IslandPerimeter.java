package Recursion;

public class IslandPerimeter {
    public static void main(String[] args) {

    }
    static int islandPerimeter(int[][] grid) {
        int rowLen = grid.length, colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == 1)
                    return dfs (grid, i, j, rowLen, colLen, 0);
            }
        }
        return 0;
    }
    static int dfs(int[][] grid, int row, int col, int rowLen, int colLen, int per) {
        if (row < 0 || row >= rowLen || col < 0 || col >= colLen || grid[row][col] == 0) {
            return per + 1;
        }
        if (grid[row][col] == -1)
            return per;

        grid[row][col] = -1;

        int[][] movements = {{1,0},{0,-1},{0,1},{-1,0}};

        for (int[] mov : movements) {
            int newRow = row + mov[0];
            int newCol = col + mov[1];

            per = dfs(grid, newRow, newCol, rowLen, colLen, per);
        }
        return per;
    }

}
