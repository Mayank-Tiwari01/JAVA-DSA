package ArrayQuestions2D;

import java.util.Arrays;

public class SetMatrixBetterSol {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] resultMatrix = SetZeroMatrix(matrix);

        for (int[] row : resultMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] SetZeroMatrix(int[][] matrix) {
        int[] rowWithZero = new int[matrix.length];
        int[] colWithZero = new int[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    rowWithZero[row] = 1;
                    colWithZero[col] = 1;
                }
            }
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (rowWithZero[row] == 1 || colWithZero[col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }
}
