package Hashing;

import java.util.*;
/*
s =
"goalspecial"
wordDict =
["go","goal","goals","special"]
chutiya.
 */
public class WordBreak {
    public static void main(String[] args) {
        String s = "ab";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");

        System.out.println(wordBreak(s, wordDict));
    }
    static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (set.contains(s.substring(start, end + 1)) && end >= s.length() - 1) {
                return true;
            }
            if (set.contains(s.substring(start, end))) {
                start = end;
            }
            if (!set.contains(s.substring(start, end))) {
                end++;
            }
        }
        return (set.contains(s.substring(start, end)));
    }
}
