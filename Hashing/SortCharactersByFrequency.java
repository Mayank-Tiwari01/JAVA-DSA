package Hashing;

import java.util.Hashtable;
import java.util.TreeMap;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(sortChar(s));
    }
    static String sortChar(String s) {
        TreeMap<Character, Integer> charFreq = new TreeMap<>();
        for (char c : s.toCharArray()) charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        StringBuilder ans = new StringBuilder();


        return ans.toString();
    }
}
