package Recursion;

public class factorial {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(findFactorial(n));
    }
    static int findFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }
}
