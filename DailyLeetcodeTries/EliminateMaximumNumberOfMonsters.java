package DailyLeetcodeTries;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {
    public static void main(String[] args) {
       int[] distance = {46,33,44,42,46,36,7,36,31,47,38,42,43,48,48,25,28,44,49,47,29,32,30,6,42,9,39,48,22,26,50,34,40,22,10,45,7,43,24,18,40,44,17,39,36};
       int[] speed = {1,2,1,3,1,1,1,1,1,1,1,1,1,1,7,1,1,3,2,2,2,1,2,1,1,1,1,1,1,1,1,6,1,1,1,8,1,1,1,3,6,1,3,1,1};
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
            else if (time[i] - i < 1) {
                return killCount;
            }
        }
        return killCount;
    }
}
