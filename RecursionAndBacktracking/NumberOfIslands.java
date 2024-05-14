package RecursionAndBacktracking;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(numIslands(grid));
    }
    static  int numIslands(char[][] grid) {
        int count = 0;
        int rowLen = grid.length, colLen = grid[0].length;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    mark (grid, i, j, rowLen, colLen);
                }
            }
        }
        return count;
    }
    static void mark (char[][] grid, int i, int j, int rowLen, int colLen) {
        if (i < 0 || i >= rowLen || j < 0 || j >= colLen || grid[i][j] == '0' || grid[i][j] == 'x')
            return;
        grid[i][j] = 'x';
        int[][] movements = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int[] move : movements) {
            int newI = i + move[0];
            int newJ = j + move[1];

            mark (grid, newI, newJ, rowLen, colLen);
        }
    }
}
