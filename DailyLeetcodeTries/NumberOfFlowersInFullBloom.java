package DailyLeetcodeTries;

//TLE
// 32 / 52 testcases passed
import java.util.Arrays;
import java.util.HashMap;

public class NumberOfFlowersInFullBloom {
    public static void main(String[] args) {
        int[][] flowers = {
                {1, 6},
                {3, 7},
                {9, 12},
                {4, 13}
        };

        int[] people = {2,3,7,11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }
    static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] fullBloom = new int[people.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int row = 0; row < flowers.length; row++) {
            int start = flowers[row][0];
            int end = flowers[row][1];
            while (start <= end) {
               map.put(start, map.getOrDefault(start, 0) + 1);
               start++;
            }
        }

        for (int i = 0; i < people.length; i++) {
            if (map.containsKey(people[i])) {
                fullBloom[i] = map.get(people[i]);
            }
        }
        return fullBloom;
    }
}
