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

}
