package DailyLeetcodeTries;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
       int[] distance = {5,4,3,3,3};
       int[] speed = {1,1,5,3,1};
        System.out.println(monsterKilled(distance, speed));

    }
    static int monsterKilled(int[] distance, int[] speed) {
        int length = distance.length;
        double[] time = new double[length];

        for (int i = 0; i < length; i++) {
            time[i] = (double) distance[i] / speed[i];
        }
        Arrays.sort(time);
        int killCount = 1;
        for (int i = 1; i < length; i++) {
            if (time[i] - i > 0) {
                killCount++;
                time[i] = time[i] - i;
            }
            else if (time[i] - i <= 0) { // this handles the case of point values. (time[i] - i < 1) also works.
                return killCount;
            }
        }
        return killCount;
    }
}
