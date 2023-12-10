package ArrayQuestions2D;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        transpose(matrix);
    }
    static int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        int rowAns = 0, colAns = 0;
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                transposedMatrix[rowAns][colAns] = matrix[row][col];
                colAns++;
            }
            rowAns++;
            colAns = 0;
        }
        return transposedMatrix;
    }
}
