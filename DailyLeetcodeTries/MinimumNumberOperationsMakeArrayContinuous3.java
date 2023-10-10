package DailyLeetcodeTries;

import java.util.HashSet;
//wrong answer.
public class MinimumNumberOperationsMakeArrayContinuous3 {
    public static void main(String[] args) {
        int[] nums = {100,97,94,91,88,85,82,79,76,73,70,67,64,61,58,55,52,49,46,43};
        System.out.println(minOperations(nums));
    }
    static int minOperations(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            hashSet.add(num);
            if (num < min) {
                min = num;
            }
        }
        int x = nums.length - 1;
        int operations = 0;

        for (int i = 1; i < x + 1; i++) {
            if (!hashSet.contains(min + i)) { // nobody said we have to start from the min, you can begin with any element, and from there the array should be continuous.
                operations++;
            }
        }
        return operations;
    }
}
