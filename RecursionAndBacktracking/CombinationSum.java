package RecursionAndBacktracking;
import java.util.*;
//https://www.youtube.com/watch?v=OyZFFqQtu98&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
//https://www.youtube.com/watch?v=GBKI9VSKdGg&list=TLPQMDQwMjIwMjRmkAQ1wsGrUg&index=1
public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinations(arr, target));
    }
    static List<List<Integer>> combinations(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinationSum(arr, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    static void findCombinationSum(int[] arr, int target, int idx, List<Integer> ds, List<List<Integer>> ans) {
        if (idx == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (arr[idx] <= target) {
            ds.add(arr[idx]);
            target -= arr[idx];
            findCombinationSum(arr, target, idx, ds, ans); //or simply write in the fun call target - arr[idx]
            target += arr[idx];
            //essential for backtracking.
            ds.remove(ds.size() - 1);
        }
        findCombinationSum(arr, target, idx + 1, ds, ans);
        //this call will take us forward in the array, this is the no pick cond.
    }
}