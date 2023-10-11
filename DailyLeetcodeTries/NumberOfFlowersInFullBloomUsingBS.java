package DailyLeetcodeTries;

import java.util.Arrays;
/*
I do not know why and how the BS is working here, why does this approach work is also not clear.
I did the brute force all on my own, but it gave TLE. FML.
 */
public class NumberOfFlowersInFullBloomUsingBS {
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
        int n = people.length;
        int m = flowers.length;
        int[] answer = new int[n];
        int[] startBlooming = new int[m];
        int[] endBlooming = new int[m];

        for (int i = 0; i < m; i++) {
            startBlooming[i] = flowers[i][0];
            endBlooming[i] = flowers[i][1] + 1;
        }
        Arrays.sort(startBlooming);
        Arrays.sort(endBlooming);

        for (int i = 0; i < n; i++) {
            int start = check(startBlooming, people[i]);
            int end = check(endBlooming, people[i]);

            answer[i] = start - end;
        }
        return answer;
    }
    static int check (int[] nums, int target) {
        int low = 0;
        int high = nums.length ;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }
        return low;
    }
}
