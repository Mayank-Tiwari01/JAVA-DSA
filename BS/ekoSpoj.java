package BS;
/*
https://www.spoj.com/problems/EKO/
 */
public class ekoSpoj {
    public static void main(String[] args) {
        int[] trees = {4, 42, 40, 26, 46};
        int req = 20;
        System.out.println(isPos(trees, req));
    }
    static boolean minHeight(int[] arr, int check, int k) {
        int collected = 0;
        for (int i : arr) {
            if (i >= k && check <= i) {
                collected += i - check;
            }
            if (collected >= k) return true;
        }
        return false;
    }
    static int isPos(int[] arr, int k) {
        int left = 1;
        int right = -1;
        int ans = -1;
        for (int i : arr) right = Math.max(i, right);
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (minHeight(arr, mid, k)) {
                ans = mid;
                left = mid + 1;
            }
            else right = mid - 1;
        }
        return ans;
    }
}
