package RecursionAndBacktracking;
import java.util.HashMap;
//https://www.youtube.com/watch?v=RoEzdG1bB9s
public class TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
    }
    static int beautifulSubsets(int[] nums, int k) {
        int[] subsets = new int[1];
        helper(nums, k, subsets, new HashMap<>(), 0);
        return subsets[0] - 1; // Subtract 1 to exclude the empty subset
    }

    static void helper(int[] nums, int k, int[] subsets, HashMap<Integer, Integer> map, int i) {
        if (i == nums.length) {
            subsets[0]++;
            return;
        }

        // Check if the current number can be included in the subset
        // we want that either the key is not present, because that just satisfies
        // the condition that there is no value that has abs difference as k
        // or if the key is present but its value is 0, that also conveys the same meaning
        if ((!map.containsKey(nums[i] - k) || map.get(nums[i] - k) == 0) &&
                (!map.containsKey(nums[i] + k) || map.get(nums[i] + k) == 0)) {
            // Include the current number
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            helper(nums, k, subsets, map, i + 1);
            // Backtrack: remove the current number
            map.put(nums[i], map.get(nums[i]) - 1);
        }
        // Exclude the current number
        helper(nums, k, subsets, map, i + 1);
    }
}
