package StringsAndStringBuilder;
/*
a bad code optimality wise, just wrote it cause idk.
 */
public class subsequence {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxy";
        String s2 = "knuxzs"; // false
        String s3 = "z"; // false;
        String s4 = ""; //true

        System.out.println(isSubsequence(s1, s4));
    }
    static boolean isSubsequence(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        if (t.isEmpty()) {
            return true;
        }

        int check = -1;

        for (int j = 0; j < t.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (t.charAt(j) == s.charAt(i)) {
                    if (t.charAt(j) == s.charAt(i) && i < check) {
                        return false;
                    }
                    if (t.charAt(j) == s.charAt(i)) {
                        check = i;
                        break;
                    }
                }
            }
        }

        if (check >= 0) {
            return true;
        }

        return false;
    }
}
