package Recursion;

public class fibonacciSeries {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(nthFibonacciNum(n));
    }
    static int nthFibonacciNum(int n) {
        if (n < 2) {
            return n;
        }
        return nthFibonacciNum(n - 1) + nthFibonacciNum(n - 2);
    }
}
