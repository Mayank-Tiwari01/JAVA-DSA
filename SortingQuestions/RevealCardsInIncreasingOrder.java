package SortingQuestions;
import java.util.Arrays;
/*
Just a trick question really
https://www.youtube.com/watch?v=S6MGVmkMz2c
also can use a queue to do this stimulation, that way we won't need the placed bool variable.
 */
public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {

    }
    static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int len = deck.length;
        int[] ans = new int[len];
        int j = 0, i = 0;
        boolean placed = false;

        while (i < len) {
            if (ans[j] == 0 && !placed) {
                ans[j] = deck[i];
                i++;
                placed = true;
            }
            if (ans[j] == 0 && placed)
                placed = false;

            j++;
            if (j == len) j = 0;
        }
        return ans;
    }
}
