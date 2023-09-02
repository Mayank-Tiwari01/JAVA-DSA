package StringsAndStringBuilder;
/*
this code just checks for how many char at string s do not appear in dictionary.
better sol at end.
 */
public class ExtraCharactersString {
    public static void main(String[] args) {
        String s = "leetscodexq";
        String[] dictionary = {"leet","code","leetcode"};
        System.out.println(extraChar(s, dictionary));
    }
    static int extraChar(String s, String[] dictionary) {
        int count = 0;
        int flag = -1;

        for (int i = 0; i < s.length(); i++) {
            for (String word : dictionary) {
                for (int j = 0; j < word.length(); j++) {
                    if (s.charAt(i) == word.charAt(j)) {
                        flag = 1;
                    }
                }
            }
            if (flag == -1) {
                count++;
            }
            flag = -1;
        }
        return count;
    }
}
/*
package StringsAndStringBuilder;

import java.util.HashSet;
import java.util.Set;

public class ExtraCharactersString {
    public static void main(String[] args) {
        String s = "leetscodexq";
        String[] dictionary = {"leet", "code", "leetcode"};
        System.out.println(extraChar(s, dictionary));
    }

    static int extraChar(String s, String[] dictionary) {
        Set<Character> charSet = new HashSet<>();

        // Add all characters from the dictionary words to a set for quick lookup.
        for (String word : dictionary) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }

        int count = 0;

        // Count characters in 's' that are not in the set.
        for (char c : s.toCharArray()) {
            if (!charSet.contains(c)) {
                count++;
            }
        }

        return count;
    }
}

 */
