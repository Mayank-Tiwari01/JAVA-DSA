package MathematicsAndBitManipulation;

public class palindromeRecursion {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(isPalindrome(n));
    }
    static int sum = 0;
    static boolean isPalindrome(int x) {
        if (x < 0) return false;
        reverseInt(x);
        return (sum == x);
    }
    static void reverseInt(int n) {
        if (n == 0) return;
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverseInt(n / 10);
    }
}


