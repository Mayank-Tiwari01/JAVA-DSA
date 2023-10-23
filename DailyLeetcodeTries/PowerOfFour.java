package DailyLeetcodeTries;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = 16777217;
        System.out.println(isPower(n));
    }
    static boolean isPower(int n) {
        for (int i = 0; i <= 15; i++) {
            int power = (int) Math.pow(4, i);
            if (power == n) {
                return true;
            }
            if (power > n) {
                return false;
            }
        }
        return false;
    }
}
