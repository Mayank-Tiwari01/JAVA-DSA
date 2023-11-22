package DailyLeetcodeTries;
/*
Understood the logic as it was pretty easy, but had a hard time getting the syntax of HashMap and 2d ArrayList.
https://www.youtube.com/watch?v=5FWc--uZRwo
 */
import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer, ArrayList<Integer>> digElements = new HashMap<>();
        int n = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (!digElements.containsKey(i + j)) {
                    digElements.put(i + j, new ArrayList<Integer>());
                }
                digElements.get(i + j).add(nums.get(i).get(j));
                n++;
            }
        }

        int[] ans = new int[n];
        int i = 0;
        int diagonal = 0;

        while(digElements.containsKey(diagonal)) {
            for (int num : digElements.get(diagonal)) {
                ans[i] = num;
                i++;
            }
            diagonal++;
        }

        return ans;
    }
}