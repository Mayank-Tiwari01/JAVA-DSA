package ArrayQuestions;
import java.util.*;
/*
https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
pretty self-explanatory code.
 */
public class PoliceAndThieves {
    public static void main(String[] args) {
        char[] arr = {'P','T','T','P'};
        int k = 2;
        System.out.println(maxThief(arr, k));
    }
    static int maxThief(char[] arr, int k) {
        ArrayList<Integer> police = new ArrayList<>();
        ArrayList<Integer> thief = new ArrayList<>();
        int idx = 0;
        for (char c : arr) {
            if (c == 'P') {
                police.add(idx);
                idx++;
            }
            if (c == 'T') {
                thief.add(idx);
                idx++;
            }
        }

        int p = 0, t = 0, count = 0;
        int pLen = police.size(), tLen = thief.size();

        while (p < pLen && t < tLen) {
            if (Math.abs(police.get(p) - thief.get(t)) <= k) {
                p++;
                t++;
                count++;
            }
            else {
                if (police.get(p) > thief.get(t)) t++;
                else p++;
            }
        }
        return count;
    }
}
