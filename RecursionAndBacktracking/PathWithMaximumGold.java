package RecursionAndBacktracking;
//why am I still struggling with backtracking?
public class PathWithMaximumGold {
    static class Solution {
        public int getMaximumGold(int[][] grid) {
            int max = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        max = Math.max(max, findPath(grid, i, j, 0));
                    }
                }
            }
            return max;
        }

        static int findPath(int[][] grid, int row, int col, int maxSum) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
                return maxSum;
            }

            int gold = grid[row][col];
            grid[row][col] = 0;

            int maxGold = Math.max(
                    findPath(grid, row - 1, col, maxSum + gold), // Up
                    Math.max(
                            findPath(grid, row + 1, col, maxSum + gold), // Down
                            Math.max(
                                    findPath(grid, row, col - 1, maxSum + gold), // Left
                                    findPath(grid, row, col + 1, maxSum + gold) // Right
                            )
                    )
            );

            grid[row][col] = gold; // Backtrack: restore the cell value

            return maxGold;
        }
    }
    static class Solution1 {
        public int getMaximumGold(int[][] grid) {
            int max = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != 0) {
                        max = Math.max(max, findPath(grid, i, j));
                    }
                }
            }
            return max;
        }

        static int findPath(int[][] grid, int row, int col) {
            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
                return 0;
            }

            int gold = grid[row][col];
            grid[row][col] = 0;
            int maxSum = 0;
            int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            for (int[] d : dir) {
                int newRow = d[0] + row;
                int newCol = d[1] + col;

                maxSum = Math.max(maxSum, findPath(grid, newRow, newCol)); // Update maxSum with the value returned by findPath
            }
            grid[row][col] = gold; // Backtrack: restore the cell value


            return maxSum + gold; // Add the current cell's gold to the maxSum
        }
    }
}
