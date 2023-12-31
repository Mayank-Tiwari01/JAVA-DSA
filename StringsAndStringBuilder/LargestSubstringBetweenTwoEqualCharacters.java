package StringsAndStringBuilder;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {
        String s = "abcedfghjakla";
        System.out.println(largestSubstring(s));
    }
    static int largestSubstring(String s) {
        int maxLen = -1, len = s.length();
        int[] charCount = new int[26];
        Arrays.fill(charCount, -1);
        for (int i = 0; i < len; i++) {
            int idx = s.charAt(i) - 'a';
            if (charCount[idx] == -1) charCount[idx] = i;
            else maxLen = Math.max(maxLen, (i - charCount[idx] - 1));
        }
        return maxLen;
    }
}
