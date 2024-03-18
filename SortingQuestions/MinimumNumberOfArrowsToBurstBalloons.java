package SortingQuestions;
import java.util.*;
/*
If you cannot understand why we sorted by the second value. Use a pen paper it will make sense.
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        //https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
    }
    static int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len == 1) return 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int totalArrows = 1;
        int currArrow = Math.min(points[0][1], points[1][1]);

        for (int i = 1; i < len - 1; i++) {
            if (currArrow < points[i][0] || currArrow > points[i][1]) {
                totalArrows++;
                currArrow = Math.min(points[i][1], points[i + 1][1]);
            }
        }
        if (currArrow < points[len - 1][0] || currArrow > points[len - 1][1])
            return totalArrows + 1;

        return totalArrows;
    }
}
