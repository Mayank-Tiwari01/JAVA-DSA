package Recursion;
import java.util.*;
//finally recursion ke questions ban ne lage??
// nah it is too good to be true.
//laal laal hogya, anti-national intellij, hindi thodi thodi aati.
//gfg has 4000+ test cases lol
//1246 /4011
//lc will accept.
public class SubsetsII {
    public static void main(String[] args) {
        int[] arr = {4,1,2,3,4,5,1};
    }
    static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        findSubsets( nums, 0, set, new ArrayList<Integer>());
        return new ArrayList<>(set);
    }
    static void findSubsets(int[] nums, int idx, HashSet<List<Integer>> set, ArrayList<Integer> ds) {
        if (idx == nums.length) {
            set.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[idx]);
        findSubsets(nums, idx + 1, set, ds);

        ds.remove(ds.size() - 1);
        findSubsets(nums, idx + 1, set, ds);
    }
}