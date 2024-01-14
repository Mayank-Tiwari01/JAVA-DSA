package Hashing;

import java.util.*;
/*
This isn't a very good code I know. I got the logic fairly quickly again, and it passes 150/153 test cases.
My logic was if all chars are present and the freq is equal too, then it is true.
But I missed one edge case where frequencies are there, but in the wrong order.
Like a = 2 times, b = 3 times, c = 3 times
and b = 3 times, c = 2 times, a = 2 times.
Now frequencies exist, but their number should also be the same.
I initially thought.
if a = 2, b = 7, c = 9
and c = 7, b = 2, a = 7. will give true, which it will, 150 test cases were passed like this, but keep in mind the above test case
Also I had already thought of the sorting answer, but I thought let's implement the O(n) code first :).
 */
public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1, word2));
    }
    static boolean closeStrings(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 != len2) return false;

        HashMap<Character, Integer> word1Freq = new HashMap<>();
        HashMap<Character, Integer> word2Freq = new HashMap<>();
        HashMap<Integer, Integer> freqOfFreq = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            word1Freq.put(word1.charAt(i), word1Freq.getOrDefault(word1.charAt(i), 0) + 1);
            word2Freq.put(word2.charAt(i), word2Freq.getOrDefault(word2.charAt(i), 0) + 1);
        }

        for (char c : word2Freq.keySet()) {
            freqOfFreq.put(word2Freq.get(c), freqOfFreq.getOrDefault(word2Freq.get(c), 0) + 1);
        }
        for (char c : word1Freq.keySet()) {
            if (!word2Freq.containsKey(c)) return false;//check if all chars exist
            if (!word2Freq.containsValue(word1Freq.get(c))) return false;
            int temp = word1Freq.get(c);
            if (freqOfFreq.get(temp) <= 0) return false;
            freqOfFreq.put(temp, freqOfFreq.get(temp) - 1);
        }
        return true;
    }
}