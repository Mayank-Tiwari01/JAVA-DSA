package StringsAndStringBuilder;
//Just keep in mind where the while loop should end, and how to avoid index out of bound for the end index.
//The most optimal answer there could be. Everything OG.
public class MinimumWindowSubstringConstSpace {
    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        System.out.println(minWindow(s, t));
    }
    static String minWindow(String s, String t) {
        int len = s.length();
        int tLen = t.length();
        if (len < t.length())
            return "";

        int[] charCount = new int[123];
        int uniqueChar = 0;
        for (char c : t.toCharArray())
            charCount[c]++;

        for (int i = 0; i < 123; i++) {
            if (charCount[i] > 0)
                uniqueChar++;
        }

        int ansS = -1, ansE = -1;
        int minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (start <= len - tLen + 1) {
            if (uniqueChar > 0) {
                charCount[s.charAt(end)]--;
                if (charCount[s.charAt(end)] == 0) {
                    uniqueChar--;
                }
                end++;
            }
            if (uniqueChar == 0) {
                if (minLength > end - start + 1) {
                    minLength = end - start + 1;
                    ansS = start; ansE = end;
                }
                charCount[s.charAt(start)]++;
                if (charCount[s.charAt(start)] == 1)
                    uniqueChar++;

                start++;
            }
            if (end == len && uniqueChar > 0) break;
        }

        if (ansS < 0) return "";

        return s.substring(ansS, ansE);
    }
}
