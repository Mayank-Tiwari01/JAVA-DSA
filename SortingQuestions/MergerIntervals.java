package SortingQuestions;
import java.util.*;
//everything og ofc.
public class MergerIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }
    static int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(temp -> temp[0]));
        ArrayList<List<Integer>> ans = new ArrayList<>();
        int temp = intervals[0][1];
        int start = intervals[0][0];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (temp >= intervals[i + 1][0]) {
                temp = Math.max(temp, intervals[i + 1][1]);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(temp);
                ans.add(list);

                temp = intervals[i + 1][1];
                start = intervals[i + 1][0];
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(temp);
        ans.add(list);

        int[][] ansArr = new int[ans.size()][2];
        int idx = 0;
        for (List<Integer> inter : ans) {
            ansArr[idx][0] = inter.get(0);
            ansArr[idx++][1] = inter.get(1);
        }
        return ansArr;
    }
    static int[][] mergeBetter(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(temp -> temp[0]));

        ArrayList<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        mergedIntervals.add(currentInterval);

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
