package MathematicsAndBitManipulation;

public class reverseNumRec {
    static int sum = 0;
    public static void main(String[] args) {
        int n = 900006;
        int ans = 0;
        while (n > 0) {
            ans += n % 10;
            n /= 10;
            ans *= (n > 0) ? 10 : 1;
        }
        System.out.println(ans);
        reverseInt(6);
        System.out.println(sum);
    }
    static void reverseInt(int n) {
        if (n == 0) return;
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseInt(n / 10);
    }
}
