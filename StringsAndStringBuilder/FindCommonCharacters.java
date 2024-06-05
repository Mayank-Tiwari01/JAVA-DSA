package StringsAndStringBuilder;
import java.util.*;
//og ofc
public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }
    static List<String> commonChars(String[] words) {
        int len = words.length;
        int[][] map = new int[len][26];
        int idx = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                map[idx][c - 'a']++;
            }
            idx++;
        }

        List<String> chars = new ArrayList<>();

        for (int j = 0; j < 26; j++) {
            int minCharFreq = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                minCharFreq = Math.min(minCharFreq, map[i][j]);
            }
            if (minCharFreq > 0)
                addChars(chars, minCharFreq, j);
        }
        return chars;
    }
    static void addChars(List<String> chars, int minCharFreq, int ascii) {
        char c = (char) (ascii + 'a');
        for (int i = 0; i < minCharFreq; i++)
            chars.add(Character.toString(c));
    }
}
