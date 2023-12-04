package DailyLeetcodeTries;

public class MinimumTimeVisitingAllPoints {
    public static void main(String[] args) {
        int[][] points = {{1,1},{3,4},{-1,0}};
        System.out.println(minTime(points));
    }
    static int minTime(int[][] points) {
        int time = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int x1 = points[i][0], x2 = points[i][1], y1 = points[i + 1][0], y2 = points[i + 1][1];
            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

            time += (Math.min(dx, dy)) + (Math.abs(dx - dy));

        }
        return time;
    }
}
