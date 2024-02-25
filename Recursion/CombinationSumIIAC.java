package Recursion;

import java.util.*;

public class CombinationSumIIAC {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 4};
        int target = 4;
        System.out.println(combinations(arr, target));
    }

    static List<List<Integer>> combinations(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations(arr, target, 0, ans, new ArrayList<>());
        return ans;
    }

    static void findCombinations(int[] arr, int target, int idx, List<List<Integer>> ans, List<Integer> ds) {
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(arr, target - arr[i], i + 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
