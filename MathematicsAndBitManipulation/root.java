package MathematicsAndBitManipulation;

public class root {
    public static void main(String[] args) {
        int n = 16;
        int p = 3;
        int root = findRoot(n);
        System.out.println(rootUptoP(root, p));
    }
    static float rootUptoP(int n, int p) {
        float fAns = n;
        float inc = 0.1F;

        for (int i = 1; i <= p; i++) {
            while(fAns * fAns <= n) {
                fAns += inc;
            }
            fAns -= inc;
            inc /= 10;
        }
        return fAns;
    }
    static int findRoot(int n) {
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
