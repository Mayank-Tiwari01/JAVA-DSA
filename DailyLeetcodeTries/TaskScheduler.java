package DailyLeetcodeTries;
//https://www.youtube.com/watch?v=rYh-Kkbzsnw&list=TLPQMTkwMzIwMjRcfyQ_foGrPw&index=2
//without pq (much more intuitive : https://www.youtube.com/watch?v=QDsFBLGL9MM
import java.util.*;
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(leastInterval(tasks, n));
    }
    //without pq
    static int leastInterval1(char[] tasks, int n) {
        int taskLen = tasks.length;
        if (n == 0) return taskLen;

        int[] count = new int[26];

        for (char c : tasks)
            count[c - 'A']++;
        Arrays.sort(count);
        int max = count[25];
        int space = max - 1;
        int idleSpots = space * n;

        for (int i = 24; i >= 0; i--) {
            if (idleSpots > 0) {
                idleSpots -= Math.min(space, count[i]);
            }
            else
                return taskLen;
        }
        return taskLen + idleSpots;
    }
    //with pq.
    static  int leastInterval(char[] tasks, int n) {
        int[] totalTasks = new int[26];
        int intervals = 0;
        for (char c : tasks)
            totalTasks[c - 'A']++;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (totalTasks[i] > 0) pq.add(totalTasks[i]);
        }

        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            //every time you can pick n + 1 tasks, cause after that we would either
            //need a cooling time or need to add the tasks which are available.
            for (int i = 0; i < n + 1; i++) {
                if (!pq.isEmpty()) {
                    int freq = pq.poll();
                    freq -= 1;
                    list.add(freq);
                }
            }
            //re-add the tasks that are processed.
            for (int j : list) {
                if (j > 0) pq.add(j);
            }
            //if we processed all the tasks, that means we did not need any cooling time
            if (pq.isEmpty()) intervals += list.size();
            //may have used a cooling time
            else intervals += n + 1;
        }
        return intervals;
    }
}