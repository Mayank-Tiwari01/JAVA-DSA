package SortingQuestions;

import java.util.Arrays;

public class leetcode1637 {
    static class Solution {
        public int maxWidthOfVerticalArea(int[][] points) {
            int length = points.length;
            int[] xAxis = new int[length];

            for (int i = 0; i < length; i++) {
                xAxis[i] = points[i][0];
            }
            Arrays.sort(xAxis);
            int maxWidth = 0;
            for (int i = 0; i < length - 1; i++) {
                maxWidth = Math.max(xAxis[i + 1] - xAxis[i], maxWidth);
            }

            return maxWidth;
        }
    }
}
