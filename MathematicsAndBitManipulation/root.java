package MathematicsAndBitManipulation;

public class root {
    public static void main(String[] args) {
        int n = 16;
        int p = 3;
        System.out.println(findRoot(n,p));
    }
    static int findRoot(int n, int p) {
        int start = 1;
        int end = n;
        int ans = -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int temp = mid * mid;
            if (temp == n) return mid;
            if (temp > n)  end = mid - 1;
            else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
