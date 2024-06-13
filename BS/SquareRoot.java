package BS;

public class SquareRoot {
    public static void main(String[] args) {
        double num = 10;
        double precision = 1e-5;
        System.out.println(BS(num, precision));
    }
    static double BS(double num, double precision) {
        if (num < 0) throw new IllegalArgumentException("Number must be non-negative");

        double left = 0;
        double right = num;

        while ((right - left) > precision) {
            double mid = (left) + (right - left) / 2;

            if (mid * mid > num)
                right = mid;
            else
                left = mid;
        }
        return (left + right) / 2;
    }
}
