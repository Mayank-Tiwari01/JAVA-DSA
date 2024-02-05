package Recursion;
import java.util.*;
//172 / 176 testcases passed
//2 ^ n * K * log(n).
public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinations(arr, target));
    }
    static List<List<Integer>> combinations(int[] arr, int target) {
        Arrays.sort(arr); //This will avoid duplicates, but give TLE.

        Set<List<Integer>> set = new HashSet<>();
        findCombinations(arr, target, 0, set, new ArrayList<Integer>());
        List<List<Integer>> ans = new ArrayList<>();

        for (List<Integer> rows : set) {
            ans.add(new ArrayList<>(rows));
        }
        return ans;
    }
    static void findCombinations(int[] arr, int target, int idx, Set<List<Integer>>ans, List<Integer> ds) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            //pick
            findCombinations(arr, target - arr[idx], idx + 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(arr, target, idx + 1, ans, ds);
        //no pick
    }
}
