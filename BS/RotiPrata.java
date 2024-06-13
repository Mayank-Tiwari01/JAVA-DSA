package BS;
// do it again properly
public class RotiPrata {
    public static void main(String[] args) {
        int prata = 10;
        int[] ranks = {1,2,3,4};
        System.out.println(timeReq(prata, ranks));
    }
    static int timeReq(int prata, int[] ranks) {
        int ans  = -1;
        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(prata, ranks, mid)) {
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        return ans;
    }
    static boolean isValid(int prata, int[] ranks, int mid) {
        int time;
        int count = 0;

        for (int rank : ranks) {
            time = rank;
            int j = 2;
            while (time <= mid) {
                count++;
                time = time + (rank * j);
                j++;
            }
            if (count >= prata)
                return true;
        }
        return false;
    }
}
