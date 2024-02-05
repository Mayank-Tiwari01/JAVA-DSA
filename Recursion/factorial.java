package Recursion;

public class factorial {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(findFactorial(n));
        System.out.println(factorialTailRec(n, 1));
        //much more optimized because tail recursion.
    }
    static int findFactorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * findFactorial(n - 1);
    }
    static int factorialTailRec(int n, int pro) {
        if (n <= 1)
            return pro;

        return factorialTailRec(n - 1, n * pro);
    }
}
