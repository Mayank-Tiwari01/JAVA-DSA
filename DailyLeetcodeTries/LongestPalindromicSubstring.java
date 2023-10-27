package DailyLeetcodeTries;
/*
Runtime
261ms
Beats 14.80%of users with Java (lol)
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "zxcvbnmnbvcxzzxcvbnmnbvcxz";
        System.out.println(longestSub(s));
    }
    static String longestSub(String s) {
        String longestStr = s.substring(0, 1);
        int maxStrlen = 0;

        if (s.length() == 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxStrlen; j < s.length(); j++) {
                if (j - i > maxStrlen && isPalindrome(s, i, j)) {
                    longestStr = s.substring(i, j + 1);
                    maxStrlen = j - i;
                }
            }
        }
        return longestStr;
    }
    static boolean isPalindrome(String s, int start, int end) {
        while (start < end ) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
