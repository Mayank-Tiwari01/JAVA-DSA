package Recursion;
import java.util.*;
public class PermutationsExtraSpace {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(permute(arr));
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] pick = new boolean[nums.length];
        findPermutations(nums, ans, new ArrayList<>(), pick);
        return ans;
    }
    static void findPermutations(int[] nums,List<List<Integer>>ans, ArrayList<Integer> ds, boolean[] pick) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                ds.add(nums[i]);
                findPermutations(nums, ans, ds, pick);
                ds.remove(ds.size() - 1);
                pick[i] = false;
            }
        }
    }
}
