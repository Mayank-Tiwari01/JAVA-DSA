package DailyLeetcodeTries;

import java.util.HashSet;

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
       int[] nums = {1,10,100,1000,10,1};
       remDuplicate(nums);
    }
    static void remDuplicate(int[] nums) {
        HashSet<Integer> remember = new HashSet<>();
        boolean isUnique = true;
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            if (remember.contains(nums[i])) {
                isUnique = false;
                nums[i] += 1;
                remember.add(nums[i]);
                operations++;
            }
            else if (!remember.contains(nums[i])) {
                remember.add(nums[i]);
            }
        }

    }
//    static int minOperations(int[] nums, boolean isUnique, int min, int max) {
//        int operations = 0;
//        return operations;
//    }
}
