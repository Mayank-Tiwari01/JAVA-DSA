package ArrayQuestions2D;

public class rotateImageInPlace {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        swap(matrix);
        int len = matrix.length;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    static void swap(int[][] matrix) {
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int row = 0; row < len; row ++) {
            reverseRow(matrix, row);
        }
    }
    static void reverseRow(int[][] matrix, int row) {
        int len = matrix.length;
        int start = 0;
        int end = len - 1;

        while (start < end) {
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++; end--;
        }
    }
}
/*
By swapping elements at (i, j) and (j, i) positions, where i and j are the row and column indices.
This effectively reflects the matrix over its main diagonal.
Second, it reverses each row of the transposed matrix to complete the rotation.
The reverseRow method is used for this purpose.
 */


