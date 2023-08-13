package ArrayQuestions2D;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        int[][] resultMatrix = SetZeroMatrix(matrix);

        for (int[] row : resultMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] SetZeroMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 0){
                    MarkRow(matrix,row);
                    MarkCOl(matrix,col);
                }
            }
        }
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[row].length; col++){
                if(matrix[row][col] == -1){
                    matrix[row][col] = 0;
                }
            }
        }
        return matrix;
    }
    static int[][] MarkRow(int[][] matrix, int row){
        int noOfCOls = matrix[0].length;
        for(int i = 0; i < noOfCOls; i++){
            if(matrix[row][i] != 0){
                matrix[row][i] = -1;
            }
        }
        return matrix;
    }
    static int[][] MarkCOl(int[][] matrix, int col){
        int noOfRows = matrix.length;

        for(int j = 0; j < noOfRows; j++){
            if(matrix[j][col] != 0){
                matrix[j][col] = -1;
            }
        }
        return matrix;
    }
}

