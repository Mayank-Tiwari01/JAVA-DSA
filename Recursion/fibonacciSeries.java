package Recursion;

public class fibonacciSeries {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(nthFibonacciNum(n));
    }
    static int nthFibonacciNum(int n) {
        if (n < 2) {
            return n;
        }
        return nthFibonacciNum(n - 1) + nthFibonacciNum(n - 2);
        //make a recursive tree and use the debugger to properly learn what this program does.
    }
}
