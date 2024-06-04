package StringsAndStringBuilder;

public class LongestPalindrome {
    static int longestPalindrome(String s) {
        int[] map = new int[123];

        for (char c : s.toCharArray()) map[c]++;
        int longestPalindromeLen = 0;
        boolean isOdd = false;

        /*
        The logic here is we can have letters with even frequency to
        form a palindrome, but we can have one letter with odd frequency,
        so we choose the letter with the highest odd frequency and add it.
        Also, one more point to think is that we do not have to use all letters,
        suppose a letter is appearing 47 times then we should not ignore it,
        rather take 46 letters out of it and form a palindrome.
        */
        for (int i = 0; i < 123; i++) {
            if (map[i] % 2 == 0) {
                longestPalindromeLen += map[i];
            }
            else {
                isOdd = true;
                longestPalindromeLen += map[i] - 1;
            }
        }
        /*
        Finally, if there is any odd frequency,
        you add 1 to the palindrome length to account
        for the center character of the palindrome.
        */
        return (isOdd) ? longestPalindromeLen + 1 : longestPalindromeLen;
    }
}
