package DailyLeetcodeTries;
/*
A very Brute Force approach. Time complexity would be O(2n) == O(n). n being row x col. Space complexity 0(numOfCols).
Runtime is 2ms. Beats 89.24% of users with java.
Could have made two arrays, one which would store how many 1 are there in a row, and the second would store
how many 1 are there in a col. And then you can iterate in the matrix again and check for every 1 if the subsequent row and col
have exactly one '1'.
 */
public class SpecialPositionsInBinaryMatrix {
    public static void main(String[] args) {
        int[][] mat = {{0,0},{0,0},{1,0}};
        System.out.println(specialPos(mat));
    }
    static int specialPos(int[][] mat) {
        int numOfRows = mat.length;
        int numOfCols = mat[0].length;
        int[] isSumOne = new int[numOfRows];

        //If there is only one 1 in a row. Then mark the col where that one single 1 is present.
        for (int row = 0; row < numOfRows; row++) {
            int sum = 0;
            int save = -1;
            for (int col = 0; col < numOfCols; col++) {
                if (mat[row][col] == 1) sum++;
                if (sum > 1) break;
                if (mat[row][col] == 1) save = col;
            }
            if (sum == 1) isSumOne[row] = save;
            else  isSumOne[row] = -1;
        }

        int perfect = 0;

        //For every place in the row that has a single 1, we see if the corresponding rows have more than one 1 or not.
        for (int i = 0; i < numOfRows; i++) {
            int sum = 0;
            for (int col = 0; col < numOfRows; col ++) {
                if (isSumOne[i] != -1 && mat[col][isSumOne[i]] == 1) sum ++;
                if (sum > 1 || isSumOne[i] == -1) break;
            }
            if (sum == 1) perfect++;
        }
        return perfect;
    }
}