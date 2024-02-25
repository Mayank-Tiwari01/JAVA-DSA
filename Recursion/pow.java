package Recursion;

public class pow {
    public static void main(String[] args) {
        int n = 5;
        int pow = 5;
        System.out.println(calPow(n, pow));
    }

    static long calPow(long base, long exp) {
        if (exp == 0) {
            return 1;
        }
        long half = calPow(base, exp / 2);
        if (exp % 2 == 0) {
            return (half * half);
        } else {
            return (base * half * half);
        }
    }
}

