package Hashing;
import java.util.*;
/*
reflect on it, please.
407 / 987 testcases passed
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(longestSubstring(s));
    }
    static int longestSubstring(String s) {
        if (s.isEmpty()) return 0;
        HashSet<Character> set = new HashSet<>();
        int longestSub = 1, count = 0;

        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                count++;
                longestSub = Math.max(count, longestSub);
            }
            else{
                set.clear();
                longestSub = Math.max(count, longestSub);
                set.add(c);
                count = 1;
            }
        }
        return longestSub;
    }
}
