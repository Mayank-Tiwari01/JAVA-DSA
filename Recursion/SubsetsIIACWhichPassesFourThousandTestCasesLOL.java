package Recursion;
import java.util.*;
//the title says it all.
//also, this question follows the same pattern as combination sum II.
//4011 /4011 GFG
public class SubsetsIIACWhichPassesFourThousandTestCasesLOL {
    public static void main(String[] args) {
        int[] nums = {3,4,5,5,6,1,1,2,3,61,2,3};
    }
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        findSubsets(nums, 0, ans, new ArrayList<Integer>());
        return ans;
    }
    static void findSubsets(int[] nums, int idx, List<List<Integer>> ans, ArrayList<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(nums, i + 1, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}
