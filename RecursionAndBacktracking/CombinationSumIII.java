package RecursionAndBacktracking;
import java.util.*;
public class CombinationSumIII {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
    }
    static List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findComb(ans, ds, 0, 0, nums, k, n);
        return ans;
    }
    static void findComb(List<List<Integer>> ans, List<Integer> ds, int idx, int sum, int[] nums, int k, int n) {
        if (sum == n && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (sum > n) return;
        if (idx == 9) return;
        ds.add(nums[idx]);
        findComb(ans, ds, idx + 1, sum + nums[idx], nums, k, n);

        ds.remove(ds.size() - 1);
        findComb(ans, ds, idx + 1, sum, nums, k, n);
    }
}
