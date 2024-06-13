package BS;

public class MinimizedMaximumOfProductsDistributedToAnyStore {
    static int minimizedMaximum(int n, int[] quantities) {
        int start = 1;
        int end = -1;

        for (int i : quantities) {
            end = Math.max(i, end);
        }
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (areStoresFilled(n, quantities, mid)) {
                ans = mid;
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return ans;
    }
    static boolean areStoresFilled(int n, int[] quantities, int mid) {
        for (int quantity : quantities) {
            n -= (int) Math.ceil((double) quantity / mid);
        }
        return n >= 0;
    }
}
