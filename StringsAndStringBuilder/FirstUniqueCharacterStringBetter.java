package StringsAndStringBuilder;

import java.util.Arrays;

public class FirstUniqueCharacterStringBetter {
    public static void main(String[] args) {
        String s = "aabcdefgg";
        System.out.println(uniqueChar(s));
    }
    static int uniqueChar(String s) {
        int[] countArr = new int[26];
        Arrays.fill(countArr, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (countArr[index] == -1) {
                countArr[index] = i;
            }
            else {
                countArr[index] = -2;
            }
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 26; i++) {
            if (countArr[i] < min && countArr[i] >= 0) {
                min = countArr[i];
            }
        }
        return (min == Integer.MAX_VALUE)? -1 : min;
    }
}
