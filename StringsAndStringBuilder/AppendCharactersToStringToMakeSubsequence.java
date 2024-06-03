package StringsAndStringBuilder;

public class AppendCharactersToStringToMakeSubsequence {
    static int appendCharacters(String s, String t) {
        int i = 0, j = 0;
        int sLen = s.length(), tLen = t.length();
        int score = 0;
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                score++;
            }
            else
                i++;
        }
        if (j == tLen) return 0;
        return tLen - score;
    }
}
