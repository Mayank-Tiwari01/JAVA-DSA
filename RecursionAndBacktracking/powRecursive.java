package RecursionAndBacktracking;
/*
a^n = a * a^n-1.
if n is even = a^n => (a^n/2)^2.
if n is odd = a^n => a(a^n/2)^2.
 */
public class powRecursive {
    public static void main(String[] args) {
        int a = 5;
        int n = 3;
        System.out.println(pow(a, n));
        System.out.println((int) Math.pow(a, n));
    }
    static int pow(int a, int n) {
        if (n == 0) return 1;
        return a *  pow(a, n-1);
    }
}
