package DailyLeetcodeTries;
/*
Wrong Answer
795 / 806 testcases passed

The formula you used to calculate the minimum distance between two points is flawed.
You used the formula minDistance = Math.sqrt((sx - fx)^2 + (sy - fy)^2),
but this formula calculates the Euclidean distance between the points,
not the minimum number of steps to reach the destination.
In this context, you should be counting steps, not distance.
 */
public class DetermineIfCellIsReachableAtGivenTime {
    public static void main(String[] args) {
        int sx = 5, sy = 1, fx = 1, fy = 4, t = 4;
        System.out.println(isReachable(sx,sy,fx,fy,t));
    }
    static boolean isReachable(int sx, int sy, int fx, int fy, int t) {
        //d = √(xB - xA)2 + (yB - yA)2
        //edge case.
        if (sx == fx && sy == fy && t == 1) {
            return false;
        }
        double minDistance = ( Math.pow((sx - fx), 2) + Math.pow((sy - fy), 2));
        minDistance =  Math.floor(Math.sqrt(minDistance));
        if (minDistance <= t ) {
            return true;
        }
        return false;
    }
}
