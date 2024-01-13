package ArrayQuestions2D;

public class RamuMangoTrees {
    public static void main(String[] args) {
        int[][] field = {
                {1, 2, 3, 1},
                {2, 6, 4, 8},
                {1, 3, 2, 7},
                {2, 0, 1, 5}
        };
        System.out.println(maxTrees(field));
    }

    static int maxTrees(int[][] field) {
        int rows = field.length;
        int cols = field[0].length;
        int[][] prefixSum = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int rowx = (row - 1 >= 0) ? row - 1 : 0;
                int colx = (col - 1 >= 0) ? col - 1 : 0;

                prefixSum[row][col] = field[row][col] +
                        (rowx > 0 ? prefixSum[rowx][col] : 0) +
                        (colx > 0 ? prefixSum[row][colx] : 0) -
                        (rowx > 0 && colx > 0 ? prefixSum[rowx][colx] : 0);
            }
        }

        return 0;
    }
}