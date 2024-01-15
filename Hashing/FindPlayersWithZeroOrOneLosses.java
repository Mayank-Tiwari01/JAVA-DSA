package Hashing;
import java.util.*;
/*
Everything OG ofc.

This question should be a reminder that you should always read the question properly before you jump in the coding part.
It asked to add the list in increasing / sorted order. I got the logic within seconds, I even coded it in 10 minutes,
the only part that was stuck was I was not sorting the list.

The logic is simple iterate in the array, and if the element is not in the map then add it with its index, index can
only be 0 or 1. If you encounter it again, there can be two cases that it previously won and now lost a match, how would
you know that? If the value of that element is 0, and now its index is 1. That means it lost a match, so update the
value as 1. Second case it already lost one match and now again the index is 1 that means he again lost the match, so
put the value as -1, signifying that it had already lost 2 matches, and now we do not care if it wins or loses.

Rest any case can be ignored: like it previously won, won again (value was 0, now again the index is also 0).
Its value is -1, so it is useless. Value is 1, now its index is 0, doesn't matter cause it already lost one match
now winning more will not help us in our answer.
 */
public class FindPlayersWithZeroOrOneLosses {
    public static void main(String[] args) {
        int[][] matches = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        System.out.println(findWinners(matches));
    }
    static List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < matches.length; i++) {
            for (int j = 0; j < 2; j++) {
                int temp = matches[i][j];
                if (map.containsKey(temp)) {
                    if (map.get(temp) == 1 && j == 1) map.put(temp, -1);
                    if (map.get(temp) == 0 && j == 1) map.put(temp, 1);
                }
                else {
                    map.put(temp, j);
                }
            }
        }

        ArrayList<Integer> winners = new ArrayList<>();
        ArrayList<Integer> oneLose = new ArrayList<>();

        for (int key : map.keySet()) {
            if (map.get(key) == 0) winners.add(key);
            if (map.get(key) == 1) oneLose.add(key);
        }

        Collections.sort(winners);
        Collections.sort(oneLose);


        ans.add(winners);
        ans.add(oneLose);

        return ans;
    }
}