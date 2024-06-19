package BS;

public class MinimumNumberOfDaysToMakeBouquets {
    public static void main(String[] args) {
        int[] bloomDay = {1000000000,1000000000};
        int k = 1;
        int m = 1;
        System.out.println(minDays(bloomDay, k, m));
    }
    static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;

        int maxDays = -1;
        for (int i : bloomDay) maxDays = Math.max(maxDays, i);

        int start = 1, end = maxDays;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] bloomDay, int mid, int m, int k) {
        int adjacentCount = 0;
        int bouquetCount = 0;
        for (int i : bloomDay) {
            if (bouquetCount == m)
                break;
            if (i <= mid)
                adjacentCount++;
            else
                adjacentCount = 0;

            if (adjacentCount == k) {
                bouquetCount++;
                adjacentCount = 0;
            }
        }
        return bouquetCount >= m;
    }
}
