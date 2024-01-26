package Recursion;

public class palindromeUsingRecursion {
    public static void main(String[] args) {
        String s = "    aya    ";
        s.trim();
        int len = s.length();
        System.out.println(isPalindrome(s, 0, len));
    }
    static boolean isPalindrome(String s, int i, int len) {
        if (i >= len / 2) return true;
        if (s.charAt(i) != s.charAt(len - i - 1)) return false;
        return isPalindrome(s, i + 1, len);
    }
}
