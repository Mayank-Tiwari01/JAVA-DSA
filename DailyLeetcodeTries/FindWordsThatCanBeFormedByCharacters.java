package DailyLeetcodeTries;

import java.util.HashMap;
/*
Most brute Force Solution I could think of, Have some ideas to optimize it a bit, but my hand is paining because of balling
OG ofc.
48ms beats 22% of users lol.
 */
public class FindWordsThatCanBeFormedByCharacters {
    public static void main(String[] args) {
        String s = "welldonehoneyr";
        String[] words = {"hello","world","leetcode"};
        System.out.println(wordsLength(words, s));
    }
    static int wordsLength(String[] words, String chars) {
        HashMap<Character, Integer> mapString = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < chars.length(); i++) {
            mapString.put(chars.charAt(i), mapString.getOrDefault(chars.charAt(i), 0) + 1);
        }
        for (String word : words) {
            HashMap<Character, Integer> mapWord = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                mapWord.put(word.charAt(i), mapWord.getOrDefault(word.charAt(i), 0) + 1);
            }
            boolean charsEqual = true;
            for (int j = 0; j < word.length(); j++) {
                if (!mapString.containsKey(word.charAt(j)) || mapString.get(word.charAt(j)) < mapWord.get(word.charAt(j))){
                    charsEqual = false;
                    break;
                }
            }
            if (charsEqual) ans += word.length();
        }
        return ans;
    }
}
