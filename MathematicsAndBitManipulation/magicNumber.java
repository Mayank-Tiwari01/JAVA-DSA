package MathematicsAndBitManipulation;

public class magicNumber {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nThMagicNum(n));
    }
    static long nThMagicNum(int n) {
        long base = 5;
        long ans = 0;
        long mod = (long) (Math.pow(10, 9) + 7); //for avoiding overflow (GFG CONSTRAINTS)
        while (n > 0) {
            long lastDigit = n & 1;
            ans += lastDigit * base;
            base *= 5;
            n >>= 1;
        }
        return ans % mod;
    }
}
