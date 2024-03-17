package DailyLeetcodeTries;
import java.util.*;
/*
A lot of edge cases, but it is easy once you have solved Q: 56, merge intervals. The catch here is, you need to see
when an interval does not contain our new interval, which we want to merge, if it cannot help us, then we directly add it.
Meaning, if the new interval is outside (be it on the right or left) the interval, then we just add the given interval and
move forward.

Also, to check if the intervals are overlapping, we have to check three things.
1: The interval start is smaller than or equal to new interval start, and the interval end is larger or equal to the new
interval end.
2: The new interval end lies between the given interval or not.
3: the interval lies inside the new interval or not.
--Very imp (any pair can be bigger and can contain the other pair, partially or fully).
 */
public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{3,5},{6,7}, {8,10},{12,16}};
        int[] newInterval = {4,8};
        System.out.println(Arrays.toString(insert(intervals, newInterval)));
    }
    static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[0] && interval[1] >= newInterval[0] || interval[0] <= newInterval[1] && interval[1] >= newInterval[1]
            || newInterval[0] <= interval[0] && newInterval[1] >= interval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            else if (interval[1] < newInterval[0] || interval[0] < newInterval[1])
                ans.add(interval);
            else {
                ans.add(newInterval);
                newInterval = interval;
            }
        }
        ans.add(newInterval);
        int[][] finalAns = new int[ans.size()][2];
        int i  = 0;
        for (int[] pair : ans) {
            finalAns[i++] = pair;
        }
        return finalAns;
    }
}
