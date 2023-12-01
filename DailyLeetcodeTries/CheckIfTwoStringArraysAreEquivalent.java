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
        StringBuilder s = new StringBuilder();
        StringBuilder x = new StringBuilder();
        for (String value : word1) {
            s.append(value);
        }
        for (String value : word2) {
            x.append(value);
        }
        return s.toString().contentEquals(x);
    }
}
