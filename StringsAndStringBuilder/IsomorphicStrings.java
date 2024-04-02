package StringsAndStringBuilder;
      /*
        Constraints:
        1 <= s.length <= 5 * 104
        t.length == s.length
        s and t consist of any valid ascii character.
         */

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";
        System.out.println(isIsomorphic(s, t));
    }
    static boolean isIsomorphic(String s, String t) {
        int len = s.length();
        if (len != t.length())
            return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < len; i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] == 0 && mapT[charT] == 0) {
                mapS[charS] = charT;
                mapT[charT] = charS;
            }
            else {
                if (mapS[charS] != charT || mapT[charT] != charS)
                    return false;
            }
        }
        return true;
    }
}
/*
Your code computes the frequency of characters in both strings and then compares the frequencies.
However, you don't need to compute frequencies separately. Instead, you can use two arrays to map characters from one
string to the other and check if the mappings are consistent.

Wrong Answer
42 / 44 testcases passed
 int[] charArrayS = new int[128];
        int[] charArrayT = new int[128];

        for (int i : s.toCharArray()) {
            charArrayS[i]++;
        }
        for (int j : t.toCharArray()) {
            charArrayT[j]++;
        }
        int[] arrayS = new int[s.length()];
        int[] arrayT = new int[t.length()];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            arrayS[i] = charArrayS[index];
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i);
            arrayT[i] = charArrayT[index];
        }

        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i] != arrayT[i]) {
                return false;
            }
        }
        return true;
    }
 */
