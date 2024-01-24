package StackAndQueue;
import java.util.*;
/*
Follows the same concept as LargestRectangleInHistogram. You just have to do what you did in LargestRectangleInHistogram.
For every row one by one, first row1, then row1 and row2, then row1 and row2 and row3 and so on. If there is 0, we will
not consider it. Watch this video to understand properly.
https://www.youtube.com/watch?v=St0Jf_VmG_g&t=932s
 */
public class MaximalRectangle {
    public static void main(String[] args) {
        int[][] matrix =
                {{0, 1 ,1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0 ,0}};
        System.out.println(maxArea(matrix));
    }
    static int maxArea(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] colSum = new int[colLen];
        int max = 0;

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == 1) colSum[col] += 1; //in leetcode it is a char so use '1'.
                else colSum[col] = 0;
            }
            int currMax = calculateMax(colSum, colLen);
            max = Math.max(currMax, max);
        }
        return max;
    }

    static int calculateMax(int[] colSum, int colLen) {
        int[] leftSmallest = LSN(colSum, colLen);
        int[] rightSmallest = RSN(colSum, colLen);
        int maxRec = 0;

        for (int i = 0; i < colLen; i++) {
            int currMaxRec = (rightSmallest[i] - leftSmallest[i] - 1) * colSum[i];
            maxRec = Math.max(maxRec, currMaxRec);
        }
        return maxRec;
    }

    static int[] LSN(int[] arr, int len) {
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] RSN(int[] arr, int len) {
        int[] ans = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = len;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
}
