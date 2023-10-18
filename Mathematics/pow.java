package Mathematics;

public class pow {
    public static void main(String[] args) {
        int n = 2;
        int power = 10;
        System.out.println(pow(n, power));
    }
    static long pow (int n, int power) {
        int ans = 1;

        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= n;
            }
            n *= n;
            power >>= 1;
        }
        return ans;
    }
}
