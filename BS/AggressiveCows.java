package BS;

import java.util.Arrays;
/*
class
https://www.geeksforgeeks.org/problems/aggressive-cows/0
https://leetcode.com/problems/magnetic-force-between-two-balls/description/
 */
public class AggressiveCows {
    public static void main(String[] args) {
        int[] stalls = {10, 1, 2, 7, 5};
        int cows = 3;
        System.out.println(findMaxDistance(stalls, cows));
    }
    static int findMaxDistance(int[] stalls, int k) {
        Arrays.sort(stalls);
        int right = stalls[stalls.length - 1];
        int left = 1;
        int dis = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isDisPossible(stalls, mid, k)) {
                dis = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return dis;
    }
    static boolean isDisPossible(int[] stalls, int distance, int k) {
        int lastCow = stalls[0];
        k--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCow >= distance) {
                k--;
                lastCow = stalls[i];
            }
            if (k == 0) return true;
        }
        return (k == 0);
    }
}
