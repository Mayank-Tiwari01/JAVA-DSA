package Recursion;
import java.util.*;
//TC : O(n! * n).
public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findPermutations(nums, ans, 0);
        return ans;
    }
    static void findPermutations(int[] nums,List<List<Integer>>ans, int idx) {
        if (idx == nums.length) {
            ans.add(makeList(nums));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            findPermutations(nums, ans, idx + 1);
            //for backtracking
            swap(nums, i, idx);
        }
    }
    static List<Integer> makeList(int[] arr) {
        List<Integer> ans = new ArrayList<>(arr.length);
        for (int i : arr) {
            ans.add(i);
        }
        return ans;
    }
    static void swap(int[] nums, int i, int idx) {
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}
