package DailyLeetcodeTries;
/*
An O(1) Solution.
 */
public class DetermineIfCellIsReachableAtGivenTimeCorrect {
    public static void main(String[] args) {
        int sx = 5, sy = 1, fx = 1, fy = 4, t = 4;
        System.out.println(isReachable(sx,sy,fx,fy,t));
    }
    static boolean isReachable(int sx, int sy, int fx, int fy, int t) {
        int horizontalDis = Math.abs(sy - fy);
        int verticalDis = Math.abs(sx - fx);
        return (t >= Math.max(horizontalDis, verticalDis));
    }
}
