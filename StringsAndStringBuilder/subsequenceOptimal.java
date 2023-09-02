package StringsAndStringBuilder;
/*
much better sol by chatgpt.
just keep in check which string is longer
 */
public class subsequenceOptimal {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "knuxzs"; // false
        String s3 = "z"; // false;
        String s4 = "adrxz"; //true

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
