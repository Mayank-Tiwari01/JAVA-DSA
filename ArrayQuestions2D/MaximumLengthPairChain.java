package ArrayQuestions2D;
/*
do again with clear mind.
 */
import java.util.Arrays;
public class MaximumLengthPairChain {
    public static void main(String[] args) {
        int[][] pairs = {
                {1, 2},
                {2, 3},
                {3, 4},
        };
        System.out.println(maxPair(pairs));
    }
    static int maxPair (int[][] pairs) {
        int count = 1;
        sortingArray(pairs);

        for (int row = 0; row < pairs.length; row++) {
            if ( (row + 1) < pairs.length && pairs[row][1] < pairs[row + 1][0] ){
                count++;
            }
        }
        return count;
    }
    static int[][] sortingArray(int[][] pairs) {

        for (int i = 1; i < pairs.length; i++) {
            int[] currentRow = pairs[i];
            int j = i - 1;

            while (j >= 0 && pairs[j][0] > currentRow[0]) {
                pairs[j + 1] = pairs[j];
                j--;
            }

            pairs[j + 1] = currentRow;
        }


        return pairs;
    }
}
