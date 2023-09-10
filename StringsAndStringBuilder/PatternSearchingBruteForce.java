package StringsAndStringBuilder;
//gfg
// O((n - m + 1) * m)

import java.util.ArrayList;

public class PatternSearchingBruteForce {
    public static void main(String[] args) {
        String str = "abcazzzz";
        String pat = "zz";
        System.out.println(searchPattern(str, pat));
    }
    static ArrayList<Integer> searchPattern (String str, String pat) {
        ArrayList <Integer> patternIndex = new ArrayList<>();
        int strLen = str.length();
        int patLen = pat.length();

        for (int i = 0; i <= (strLen - patLen); i++) {
            int j;
            for (j = 0; j < patLen; j++) {
                if (pat.charAt(j) != str.charAt(i + j)) {
                    break;
                }
            }
            if (j == patLen) {
                patternIndex.add(i);
            }
        }
        return patternIndex;
    }
}
