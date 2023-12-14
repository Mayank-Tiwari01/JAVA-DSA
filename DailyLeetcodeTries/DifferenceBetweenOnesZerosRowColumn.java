package DailyLeetcodeTries;
/*
Everything OG ofc. Took a lot of time to get to this logic even though it was in front of me the whole time.
The intuition was that you literally want to subtract the number of 1's from the number of 0's.
So, while transversing through the rows, subtract the number of 1's from the number of 0's and save it in an array.
Do the same while transversing through the cols.
Now you just have to add these two things together. This would require to transverse the array 3 times.
1: row wise, 2: col wise, 3: while making the difference array. So, the TC is O(3N) == O(N). N = m * n.
7ms runtime. Beats 79.6% of users with java.
ChatGPt modified the code a little bit and reduced the complexity from O(3N) to O(2N). Which is the same thing, but it is still better.
6ms runtime. Beats 86.7% of users with java.
See comments below. Also, the second comment is how I was approaching the question at first.
 */
import java.util.Arrays;

public class DifferenceBetweenOnesZerosRowColumn {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,1}};
        System.out.println(Arrays.deepToString(diffArr(grid)));
    }
    static int[][] diffArr(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] oneMinusZeroRow = new int[rows];
        int[] oneMinusZeroCol = new int[cols];

        for (int row = 0; row < rows; row++) {
            int numOne = 0, numZero = 0;
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) numOne++;
                else numZero++;
            }
            oneMinusZeroRow[row] = numOne - numZero;
        }

        for (int col = 0; col < cols; col++) {
            int numOne = 0, numZero = 0;
            for (int row = 0; row < rows; row++) {
                if (grid[row][col] == 1) numOne++;
                else numZero++;
            }
            oneMinusZeroCol[col] = numOne - numZero;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = oneMinusZeroRow[i] + oneMinusZeroCol[j];
            }
        }
        return grid;
    }
}
/*
GPT:
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[] oneMinusZeroRow = new int[rows];
        int[] oneMinusZeroCol = new int[cols];

        // Iterate through the matrix once
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    oneMinusZeroRow[row]++;
                    oneMinusZeroCol[col]++;
                } else {
                    oneMinusZeroRow[row]--;
                    oneMinusZeroCol[col]--;
                }
            }
        }

        // Construct the difference matrix diff
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = oneMinusZeroRow[i] + oneMinusZeroCol[j];
            }
        }
        return grid;
    }
}
 */
/*
int[] oneRow = new int[rows];
        int[] oneCol = new int[cols];
        int[] zeroRow = new int[rows];
        int[] zeroCol = new int[cols];

        for (int row = 0; row < rows; row++) {
            int numOneRow = 0;
            int numZeroRow = 0;
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) numOneRow++;
                else numZeroRow++;
            }
            oneRow[row] = numOneRow;
            zeroRow[row] = numZeroRow;
        }

        for (int col = 0; col < cols; col++) {
            int numOneCol = 0;
            int numZeroCol = 0;
            for (int row = 0; row < rows; row++) {
                if (grid[row][col] == 1) numOneCol++;
                else numZeroCol++;
            }
            oneCol[col] = numOneCol;
            zeroCol[col] = numZeroCol;
        }
 */