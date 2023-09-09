package StringsAndStringBuilder;
/*
this solution beats 100% of users in java in leetcode (only return the first index in that question)
 */
import java.util.ArrayList;

public class PatternSearchingBruteForce {
    public static void main(String[] args) {
        String str = "abcabcdabcyxabcdabxabcdabcdabcyabcdabcy";
        String pat = "abcdabcy";
        System.out.println(searchPattern(str, pat));
    }
    static ArrayList<Integer> searchPattern (String str, String pat) {
        ArrayList <Integer> patternIndex = new ArrayList<>();
        if (pat.length() == 1) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == pat.charAt(0)) {
                    patternIndex.add(i);
                }
            }
        }
        else {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == pat.charAt(0)) {
                    if (str.regionMatches(j, pat, 0, pat.length())) {
                        patternIndex.add(j);
                    }
                }
            }
        }
        return patternIndex;
    }
}
/*
how regionMatches works internally:

It first checks if the specified regions in both strings have the same length.
If they don't, it returns false immediately because strings with different lengths cannot be equal.

If the lengths match, it iterates over the characters in both regions and compares them character by character,
starting from the specified positions.

It continues comparing characters until one of the following conditions is met:

All characters in both regions are compared, and they are all equal.
In this case, it returns true because the specified regions are equal.
A pair of characters is found to be different. In this case, it returns false because the strings are not equal.
If it reaches the end of the specified regions without finding any differences,
it returns true because the regions are equal.
 */
