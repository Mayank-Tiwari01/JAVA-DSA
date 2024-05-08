package SortingQuestions;
import java.util.*;
public class RelativeRanks {
    public static void main(String[] args) {
        int[] score = {5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }

    private static String[] findRelativeRanks(int[] score) {
        HashMap<Integer, String> map = new HashMap<>();
        int len = score.length;
        int[] saveArray = new int[len];

        System.arraycopy(score, 0, saveArray, 0, len);

        Arrays.sort(score); // Using Collections.reverseOrder() would make this easier, but we cannot use it because
        //Arrays.sort() method expects an array of a reference type (i.e., objects). idk the exact reason
        for (int i = 0; i < len; i++) {
            if (i == len - 1)
                map.put(score[i], "Gold Medal");
            else if (i == len - 2)
                map.put(score[i], "Silver Medal");
            else if (i == len - 3)
                map.put(score[i], "Bronze Medal");
            else
                map.put(score[i], Integer.toString(len - i));
        }
        String[] ans = new String[len];

        for (int i = 0; i < len; i++) {
            ans[i] = map.get(saveArray[i]);
        }
        return ans;
    }
}
