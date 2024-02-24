package Recursion;

import java.util.Arrays;

public class fibonacciSeries {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(Arrays.toString(fibonacciSeriesArr(n)));
        System.out.println(nthFibonacciNum(n));
    }
    //without recursion.
    static int[] fibonacciSeriesArr(int n) {
        int[] series = new int[n + 1];
        series[0] = 0; series[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            series[i] = series[i - 1] + series[i - 2];
        }
        return series;
    }
    static int nthFibonacciNum(int n) {
        if (n <= 2) {
            return 1;
        }
        return nthFibonacciNum(n - 1) + nthFibonacciNum(n - 2);
        //Make a recursive tree and use the debugger to properly learn what this program does.
        //Tc (2^n) is exponential in nature.
        // Dp can reduce it.
    }
}
