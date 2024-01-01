package SortingQuestions;
import java.util.*;
public class AssignCookies {
    public static void main(String[] args) {
        //did this question directly on leetcode so :)
        //initialize two arrays.
    }
    static int contentChildren(int[]g, int[]s){
        Arrays.sort(g);
        Arrays.sort(s);
        int pointG = 0, counter = 0;
        int gLen = g.length, sLen = s.length;

        for (int i = 0; i < sLen && pointG < gLen; i++) {
            if (s[i] >= g[pointG]) {
                counter++;
                pointG++;
            }
        }
        return counter;
    }
}

