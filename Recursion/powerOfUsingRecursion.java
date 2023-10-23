package Recursion;

public class powerOfUsingRecursion {
    public static void main(String[] args) {
        int n = 16777220;
        System.out.println(isPower(n));
    }
    static boolean isPower(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 4 != 0) return false;
        return isPower(n / 4);
    }
}
