package DailyLeetcodeTries;
/*
Meh.
1 ms Beats 73.30% of users with Java.
Have AutoMata ETE tomorrow, so did the most lazy solution.
 */
public class CheckIfTwoStringArraysAreEquivalent {
    public static void main(String[] args) {
        String[] word1 = {"abc", "d", "defg"};
        String[] word2 = {"abcddefg"};
        System.out.println(isSame(word1, word2));
    }
    static boolean isSame(String[] word1, String[] word2) {
        String s = "";
        String x = "";
        for (int i = 0; i < word1.length; i++) {
            s += word1[i];
        }
        for (int i = 0; i < word2.length; i++) {
            x += word2[i];
        }
        return s.equals(x);
    }
}
