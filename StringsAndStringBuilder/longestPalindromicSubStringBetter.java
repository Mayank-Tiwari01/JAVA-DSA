package StringsAndStringBuilder;

public class longestPalindromicSubStringBetter {
    public static void main(String[] args) {
        String s = "abb";
        System.out.println(longestSub(s));
    }
    static String longestSub(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        String maxSub = s.substring(0,1);
        int maxLen = 1;

        for (int i = 0; i < len - 1; i++) {
            // had to call the method for both even and odd because if you try to call them based on the length
            //of string, then a lot of test cases fail, I tried it (see below).
            String odd =  middleExpand(s, i, i);
            String even = middleExpand(s, i, i + 1);
            if (odd.length() > maxLen) {
                maxLen = odd.length();
                maxSub = odd;
            }
            if (even.length() > maxLen) {
                maxLen = even.length();
                maxSub = even;
            }
        }
        return maxSub;
    }
    static String middleExpand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
/*
public class Solution {
    public String longestPalindrome(String s) {
         int len = s.length();
        if (len <= 1) {
            return s;
        }
        String maxSub = s.substring(0,1);
        int maxLen = 1;

        for (int i = 0; i < len - 1; i++) {
            if ((len & 1) == 1) {
                String temp = middleExpand(s, i, i);
                if (maxLen < temp.length()) {
                    maxLen = temp.length();
                    maxSub = temp;
                }
            }
            else {
                String temp = middleExpand(s, i, i + 1);
                if (maxLen < temp.length()) {
                    maxLen = temp.length();
                    maxSub = temp;
                }
            }
        }
        return maxSub;
    }
    static String middleExpand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return s.substring(start + 1, end);
    }
}
 */