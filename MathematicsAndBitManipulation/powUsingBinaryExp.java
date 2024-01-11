package MathematicsAndBitManipulation;

public class powUsingBinaryExp {
    public static void main(String[] args) {
        int n = 2;
        int power = 13;
        System.out.println(powBinaryExponentiation(n, power));
        System.out.println((int) Math.pow(n, power));
    }
    static long powBinaryExponentiation (int n, int power) {
        int ans = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= n;
            }
            n *= n;
            power >>= 1;
            //power = power >> 1;
        }
        return ans;
    }
}
