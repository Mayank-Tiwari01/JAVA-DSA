package MathematicsAndBitManipulation;
//Brute force solution that will give MLE. See optimal solution in the recursion section.
public class CountGoodNumbers {
    public static void main(String[] args) {
        long n = 5;
        System.out.println(countGoodNumbers(n));
    }
    static int countGoodNumbers(long n) {
        long ans = 1;
        int mod = 1000000007;
        int temp = (int) n / 2;
        long[] fivePow = new long[temp + 2];
        long[] fourPow = new long[temp + 1];
        fivePow[0] = 1; fourPow[0] = 1;
        for (int i = 1; i < temp + 1; i++) {
            fivePow[i] = (fivePow[i - 1] * 5) % mod;
            fourPow[i] = (fourPow[i - 1] * 4) % mod;
        }
        fivePow[temp + 1] = (fivePow[temp] * 5) % mod;

        if (n % 2 == 0) {
            long even =  (fivePow[temp] % mod);
            long odd = (fourPow[temp] % mod);
            ans = (even * odd) % mod;
            return (int) ans % mod;
        }
        long even =  (fivePow[temp + 1] % mod);
        long odd = (fourPow[temp] % mod);
        ans = (even * odd) % mod;
        return (int) ans % mod;
    }
}
