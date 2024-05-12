package ArrayQuestions2D;

import java.util.Arrays;
//everything og lol
public class LargestLocalValuesInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        System.out.println(Arrays.deepToString(largestLocal(matrix)));
    }
    static int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] largestMatrix = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                largestMatrix[i][j] = Math.max(findLargest(grid, i, j), largestMatrix[i][j]);
            }
        }
        return largestMatrix;
    }
    static int findLargest(int[][] grid, int i, int j) {
        int max = -1;

        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                if (grid[row][col] > max) {
                    max = grid[row][col];
                }
            }
        }
        return max;
    }
}
