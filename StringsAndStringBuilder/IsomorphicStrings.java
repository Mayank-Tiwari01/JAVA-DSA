package StringsAndStringBuilder;
      /*
        Constraints:
        1 <= s.length <= 5 * 104
        t.length == s.length
        s and t consist of any valid ascii character.
         */

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "aabbcc";
//        String t = "ddeeff$$$";// false
        String t = "ddeeff"; //true
        System.out.println(isIsomorphic(s, t));
    }
    static boolean isIsomorphic(String s, String t) {
        //
        int[] mapS = new int[126];
        int[] mapT = new int[126];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS[charS] != mapT[charT]) {
                return false;
            }

            // Initialize the mappings if they are not set yet
            if (mapS[charS] == 0) {
                mapS[charS] = i + 1;
                mapT[charT] = i + 1;
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
