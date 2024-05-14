package RecursionAndBacktracking;

public class CountGoodNumbers {
    public static long mod = 1_000_000_007;
    public static void main(String[] args) {
         long n = 50;
        System.out.println(countGoodNumbers(n));
    }
    static int countGoodNumbers(long n) {
        //long mod = 1000000007;
        long temp = n / 2;
        long ans = 1;
        if (n % 2 == 0) {
            long evenPlace = calPow(5, temp) % mod;
            long oddPlace = calPow(4, temp) % mod;
            ans = (evenPlace * oddPlace) % mod;
            return (int) (ans % mod);
        }
        long evenPlace = calPow(5, temp + 1) % mod;
        long oddPlace = calPow(4, temp) % mod;
        ans = (evenPlace * oddPlace) % mod;
        return (int) (ans % mod);
    }

    static long calPow(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        long half = calPow(base, exp / 2) % mod;
        if (exp % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (base * half * half) % mod;
        }
    }
}