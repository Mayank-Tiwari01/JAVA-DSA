package StringsAndStringBuilder;
/*
Everything OG ofc. Got the intuition when I was not getting any intuition to solve it optimally.
Thought of brute forcing and while doing it got the approach to solve it optimally.
1ms, Beats 97.78%. TC = O(2N) == O(N). SC = O(1).
After that I did try to do the brute force solution. Paste it below.
 */
public class MaximumScoreAfterSplittingAString {
    public static void main(String[] args) {
        String binary = "10110001010110100010";
        System.out.println(maxScore(binary));
    }
    static int maxScore(String s) {
        int numOfOne = 0, numOfZero = 0, scoreMax = 0, length = s.length();

        // Count the total number of ones in the string
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') numOfOne++;
        }

        // Iterate through the string to calculate the score for each split
        for (int j = 0; j < length - 1; j++) {
            if (s.charAt(j) == '0') numOfZero++;
            else numOfOne--;

            // Update the maximum score for each split
            scoreMax = Math.max(scoreMax, (numOfOne + numOfZero));
        }
        return scoreMax;
    }
}
/*
brute force : O(n^2). runtime = 4ms. Beats 44%
class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0, max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') zeros++;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == '1') ones++;
            }
            max = Math.max(max, zeros + ones);
            ones = 0;
        }
        return max;
    }
}
 */
