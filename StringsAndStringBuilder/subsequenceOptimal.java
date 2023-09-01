package StringsAndStringBuilder;
/*
much better sol by chatgpt.
return indexTwo == two.length(); was an amazing way to figure out the sol.
also would work for only when the main string and the subsequence string is pre-defined, i.e the leetcode question will fail.
 */
public class subsequenceOptimal {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "knuxzs"; // false
        String s3 = "z"; // false;
        String s4 = "ahbgdc"; //true

        System.out.println(isSubsequence(s1, s4));
    }

    static boolean isSubsequence (String s, String t) {
        int indexS = 0;
        int indexT = 0;

        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexT++;
            }
            indexS++;
        }

        return indexT == t.length();
    }
}
