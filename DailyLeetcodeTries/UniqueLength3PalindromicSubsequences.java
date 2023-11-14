package DailyLeetcodeTries;
/*
Solved this question without any hints or idea, just had to take chatGPT's help to initialize a 2d ArrayList.
Everything else is original and my own, feeling very nice.
 */
import java.util.ArrayList;
import java.util.HashSet;

public class UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        String s = "aabca";
        System.out.println(countPalindromicSubsequence(s));
    }
    static int countPalindromicSubsequence(String s) {
        int count = 0;
        ArrayList<ArrayList<Integer>> repeatChar = new ArrayList<>();
        // Initialize the outer ArrayList
        for (int i = 0; i < 26; i++) {
            repeatChar.add(new ArrayList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            int row = s.charAt(i) - 'a';
            // Initialize the inner ArrayList if not already initialized
//            if (repeatChar.get(row) == null) {
//                repeatChar.set(row, new ArrayList<>());
//            }
            repeatChar.get(row).add(i);
        }
        for (int i = 0; i < 26; i++) {
            int length = repeatChar.get(i).size();
            if (length > 1) {
                count += uniquePalindrome(s, repeatChar.get(i).get(0), repeatChar.get(i).get(length - 1));
            }
        }
        return count;
    }
    static int uniquePalindrome(String s, int first, int last) {
        HashSet<Character> hashSet = new HashSet<>();
        int midChars = first + 1;
        while (last - first != 0 && midChars < last) {
            hashSet.add(s.charAt(midChars));
            midChars++;
        }
        return hashSet.size();
    }
}
