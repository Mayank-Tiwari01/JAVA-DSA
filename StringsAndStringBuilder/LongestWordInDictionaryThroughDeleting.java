package StringsAndStringBuilder;

import java.util.*;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        String[] s = {"ale","monkey","apple","plea", "monkey"};
        Arrays.sort(s);
        StringBuilder ss = new StringBuilder();
        System.out.println(Arrays.toString(s));
        System.out.println(ss);
        //https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
    }
    static String findLongestWord(String s, List<String> dictionary) {
//        Collections.sort(dictionary);
        int maxLen = 0;
        String longestWord = "";

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                //compareTo will check the lexicographical thing.
                if (word.length() > maxLen || (word.length() == maxLen  && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                    maxLen = word.length();
                }

            }
        }
        return longestWord;
    }
    static boolean isSubsequence(String word, String s) {
        if (s.length() < word.length()) return false;
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < word.length() && pointer2 < s.length()) {
            if (word.charAt(pointer1) == s.charAt(pointer2)) {
                pointer1++;
            }
            else
                pointer2++;
        }
        return (pointer1 == word.length());
    }
}
/*
String s1 = "apple";
String s2 = "banana";
String s3 = "apple";

System.out.println(s1.compareTo(s2)); // Output: -1 (because "apple" comes before "banana" lexicographically)
System.out.println(s2.compareTo(s1)); // Output: 1 (because "banana" comes after "apple" lexicographically)
System.out.println(s1.compareTo(s3)); // Output: 0 (because "apple" and "apple" are equal lexicographically)
 */