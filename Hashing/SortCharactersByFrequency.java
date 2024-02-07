package Hashing;

import java.util.*;
//everything OG
//5
//ms
//Beats
//94.72%
//of users with Java

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
    public static String frequencySort(String s) {
        int[] charFreq = new int[123];
        for (char c : s.toCharArray())
            charFreq[c]++;

        List<List<Integer>> freq = new ArrayList<>();

        for (int i = 0; i < 123; i++) {
            if (charFreq[i] != 0) {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(charFreq[i]);
                freq.add(temp);
            }
        }
        StringBuilder ans = new StringBuilder();
        freq.sort(Comparator.comparing(list -> list.get(1), Comparator.reverseOrder()));
        //Collections.sort(freq, Comparator.comparing(list -> list.get(1), Comparator.reverseOrder()));
        for (List<Integer> row : freq) {
            int i = row.get(0);
            char c = (char) i;
            int temp = row.get(1);
            while (temp > 0) {
                ans.append(c);
               temp--;
            }
        }
        return ans.toString();
    }
}