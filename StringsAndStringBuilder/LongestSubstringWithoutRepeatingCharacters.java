package StringsAndStringBuilder;
import java.util.*;
/*
Everything OG and did a lot of hard work went into making it OG.
This question took my heart and soul out of me. Not that hard, but omg, you have to actually understand the approach in-depth
to do this.
First thing to remember: updating the start pointer is the most important thing
second: update the char's index as they keep coming and if the char is repeating, but it is behind the start index, then
it will have no harm to our substring.
Third: keep updating the INDEX.
Fourth: You can also use an array of size 128 cause remember you are just updating the index. I don't get the logic though
because I have used all my brain's juice.(this is what happens when you try to use a Sliding window, without learning it)
Acceptance Rate is 34.3% (for a reason bro)
 */
class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "easfebwedjfhbsf";
        System.out.println(longestSub(s));
    }
    static int longestSub(String s) {
        int len = s.length();
        int start = 0, longest = 0;
        HashMap<Character, Integer> set = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if (!set.containsKey(s.charAt(i)) || set.get(s.charAt(i)) < start){
                longest = Math.max(i - start + 1, longest);
            }
            else{
                start = set.get(s.charAt(i)) + 1;
            }
            set.put(s.charAt(i), i);
        }
        return longest;
    }
}
