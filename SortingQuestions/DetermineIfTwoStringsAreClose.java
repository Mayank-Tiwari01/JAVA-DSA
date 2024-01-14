package SortingQuestions;

import java.util.*;
/*
Much optimal.
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }
    static boolean closeStrings(String word1, String word2) {
        int len = word1.length();
        if (len != word2.length()) return false;

        int[] charCount1 = new int[26];
        int[] charCount2 = new int[26];

        for (int i = 0; i < len; i++) {
            charCount1[word1.charAt(i) - 'a']++;
            charCount2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (charCount1[i] > 0 && charCount2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(charCount1);
        Arrays.sort(charCount2);

        for (int i = 0; i < 26; i++) {
            if (charCount1[i] != charCount2[i] )  return false;
        }
        return true;
    }
}