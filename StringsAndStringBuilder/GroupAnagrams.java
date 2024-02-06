package StringsAndStringBuilder;

import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    static List<List<String>> groupAnagrams (String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            countChars(s, count);
            String key = Arrays.toString(count);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            }
            else {
                map.put(key, new ArrayList<>());
                map.get(key).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
    static List<List<String>> groupAnagramsError(String[] strs) {
        HashMap<int[], List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            countChars(s, count);
            //The problem here is that arrays do not override the equals method as you might expect.
            // As a result, when you use arrays as keys in a HashMap,
            // the default equals method compares references, not the content of the arrays.
            //And here every reference is different from each other as we are making a new array each time.
            if (map.containsKey(count)) {
                map.get(count).add(s);
            }
            else map.put(count, new ArrayList<>());
        }
        return new ArrayList<>(map.values());
    }
    static void countChars (String s, int[] arr) {
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
    }
}

