package DailyLeetcodeTries;

import java.util.Arrays;
/*
Did it one go, Everything OG of course, really easy question.
Runtime 27 ms Beats 98.94% of users with Java
 */
public class MaximumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        int[] piles = {9,8,7,6,5,1,2,3,4};
        System.out.println(maxCoins(piles));
    }
    static int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int triplet = len / 3;
        int maxCoin = 0;
        int firstChoice = len - 2;
        while (triplet > 0) {
            maxCoin += piles[firstChoice];
            triplet--;
            firstChoice -= 2;
        }
        return maxCoin;
    }
}
