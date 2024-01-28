package ArrayQuestions2D;
import java.util.*;
/*
A real hard problem, watch this video, and also we are covering every possible matrix that can start with an element, and
then we go row wise down and check. Just remember that we are going to cover all possible matrices.
https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/?envType=daily-question&envId=2024-01-28
Tc = O(m * n + m * n ^ 2) ~ O(m * n ^ 2). SC = O(m * n).
 */
public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        System.out.println(numSubmatrixSumTarget(matrix, target));
    }
    static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int[][] prefixSum = findPrefixSum(matrix, rowLen, colLen);

        int count = 0;

        for (int col = 0; col < colLen; col++) {

            for (int col1 = col; col1 < colLen; col1++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                int sum = 0;
                map.put(0, 1);

                for (int row = 0; row < rowLen; row++) {
                    sum += (col == 0)? prefixSum[row][col1] : (prefixSum[row][col1] - prefixSum[row][col - 1]);
                    int temp = sum - target;
                    if (map.containsKey(temp)) {
                        count += map.get(temp);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
    static int[][] findPrefixSum(int[][] matrix, int m, int n) {
        int[][] prefixSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j];
                prefixSum[i][j] = sum;
            }
        }
        return prefixSum;
    }

}
