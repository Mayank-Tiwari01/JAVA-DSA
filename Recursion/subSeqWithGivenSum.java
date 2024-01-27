package Recursion;
import java.util.*;
public class subSeqWithGivenSum {
    public static void main(String[] args) {
        int[] nums= {10,1,2,7,6,1,5};
        int target = 8;
        subSeqWithKSum(nums, target);
    }
    static void subSeqWithKSum(int[] nums, int k) {
        ArrayList<List<Integer>> subSeq = new ArrayList<>();
        helper(nums, 0, k, new ArrayList<>(), subSeq, 0);
        System.out.println(subSeq);
    }
    static void helper(int[] nums, int idx, int k, ArrayList<Integer> temp, ArrayList<List<Integer>> subSeq, int sum) {
        if (sum == k) {
            subSeq.add(new ArrayList<>(temp)); // Create a new ArrayList to avoid sharing the reference
            return;
        }
        else if (idx == nums.length - 1 || sum > k) return;
        temp.add(nums[idx]);
        sum += nums[idx];
        helper(nums, idx + 1, k, temp, subSeq, sum);

        sum -= nums[idx];
        temp.remove(temp.size() - 1);

        helper(nums, idx + 1, k, temp, subSeq, sum); //using idx++ will not work cause it will pass idx then do ++
        //use ++idx or idx + 1.
        /*
        It would increment idx after its current value is used in the method call, potentially leading to incorrect results in subsequent recursive calls.
        Therefore, it's good practice to use idx + 1 or ++idx to explicitly convey the intention of incrementing before the method call.
         */
    }
}
