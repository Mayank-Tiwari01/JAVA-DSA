package DailyLeetcodeTries;
/*
Learned it from a solution.
My solution was original but bad. It is fin.
 */
public class MinimumTimeToMakeRopeColorfulGreedyGood {
    public static void main(String[] args) {
        String colors = "aabaa";
        int[] neededTime = {1,2,3,4,1};
        System.out.println(minTime(colors, neededTime));
    }
    static int minTime(String colors, int[] neededTime) {
        int len = neededTime.length;
        int min = 0;

        for (int i = 1; i < len; i++) {
            if (colors.charAt(i - 1) == colors.charAt(i)) {
                min += Math.min(neededTime[i-1], neededTime[i]);
                neededTime[i] = Math.max(neededTime[i-1], neededTime[i]);
            }
        }
        return min;
    }
}
