package StringsAndStringBuilder;

import java.util.Arrays;

public class LeftmostRepeatingCharacterOptimal {
    public static void main(String[] args) {
        String s = "abcdefghijj";
        System.out.println(repeatingChar(s));
    }
    static int repeatingChar(String s) {
        int result = Integer.MAX_VALUE;
        int[] tempArr = new int[256];
        Arrays.fill(tempArr, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i);
            if (tempArr[index] == -1) {
                tempArr[index] = i;
            }

            else {
                result = Math.min(result, tempArr[index]);
            }
        }
        return (result==Integer.MAX_VALUE)?-1:result;
    }
}

/*
if the string only has lower alphabets
class Solution {
    public int firstUniqChar(String s) {
        int[] charArr = new int[26];
        Arrays.fill(charArr, -1);
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (charArr[index] == -1) {
                charArr[index] = i;
            }

            else {
                result = Math.min(result, charArr[index]);
            }
        }

        return (result == Integer.MAX_VALUE)?-1 : result;
    }
}
 */