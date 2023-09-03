package StringsAndStringBuilder;
import java.util.*;
public class FirstUniqueCharacterStringHash {
    public static void main(String[] args) {
        String s = "aabcdefgg";
        System.out.println(uniqueChar(s));
    }
    static int uniqueChar(String s) {
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Populate the hash map with character frequencies.
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Find the first character with a frequency of 1.
        for (int i = 0; i < s.length(); i++) {
            if (charCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        // If no unique character is found, return -1.
        return -1;
    }
}