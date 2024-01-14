package Hashing;

import java.util.HashMap;
/*
EVERYTHING OG OFC!!!!
Did this in one go that too in linear time and then checked to see my rank in placements, and they put me in the top 10%
that is Dean's List.
Feeling pretty happy.(Aditya verma said this is the highest difficulty that sliding window reaches,
so doing this myself is nice, not great, but nice),
So at first I wasn't getting the question, but Within 10-15 minutes, I got what it was asking.

This follows the same pattern as many other sliding window questions follow, such as MinimumSizeSubarraySum.
The logic is if you do not have enough chars, you go forward in the string to look for it, use Hash Map and the size of
it will be the unique chars, any time a chars value becomes 0 you reduce 1 from unique chars, this way you know when
you got all the chars.
Once you got it, see if you can shrink it?
But where will you shrink it from?
From the start!
Why?
Cause going forward will give you more chars and that will increase the window duh.
So decrease the window from
the last and keep checking if the unique char is still zero or not, if while decreasing, you find a character that we need
we increase the count/value/frequency, signifying that we passed one char that we needed, if by increasing the freq is
less than or equal to 0 then no need to update unique chars.
If the freq is in minus while decreasing the window, that means
we have more than needed freq of that specific character, so we do not mind going past that.
But if while decreasing,
the count becomes 1, then you update the unique chars variable, and save this length.
Then again, you have unique char as 1,
so you will go ahead to search for it.

It was my OG approach, but this video explains exactly this approach.
So yeah, my thought was not original.
Big deal?

https://www.youtube.com/watch?v=3Bp3OVD1EGc
https://www.youtube.com/watch?v=iwv1llyN6mo&list=TLPQMTQwMTIwMjTNCmnlGCjdtw&index=2 (38:10)
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    static String minWindow(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen < tLen) return "";

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : t.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0, uniqueChar = charCount.size();
        int idxS = -1, idxE = -1, minSize = Integer.MAX_VALUE;

        while (start <= sLen - tLen + 1) {

            //if you need more chars then increase the window size by doing end++.
            if (uniqueChar > 0) {
                if (end < sLen && charCount.containsKey(s.charAt(end))) {
                    char c = s.charAt(end);
                    charCount.put(c, charCount.get(c) - 1);
                    if (charCount.get(c) == 0) uniqueChar--;
                }
                end++;
            }

            //if you have a substring that satisfied string t, then see if you can reduce the window.
            if (uniqueChar == 0) {
                if (minSize > end - start ) {
                    minSize = end - start;
                    idxS = start;
                    idxE = end - 1;
                }
                if (charCount.containsKey(s.charAt(start))) {
                    char c = s.charAt(start);
                    charCount.put(c, charCount.get(c) + 1);
                    if (charCount.get(c) == 1) uniqueChar++;
                }
                start++;
            }

            //if you reached the end, and the last window did not satisfy string t, then you can't go ahead.
            if (end == sLen && uniqueChar > 0) break;
        }

        if (idxS < 0 || idxE < 0) return "";
        return s.substring(idxS, idxE + 1);
    }
}
