package DailyLeetcodeTries;

import java.util.HashSet;

public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
       int[] nums = {100,97,94,91,88,85,82,79,76,73,70,67,64,61,58,55,52,49,46,43}; //1,10,100,1000,10,1
        System.out.println(remDuplicate(nums));
    }
    static int remDuplicate(int[] nums) {
        HashSet<Integer> remember = new HashSet<>();
        boolean isUnique = true;
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (remember.contains(nums[i])) {
                isUnique = false;
            }
            else if (!remember.contains(nums[i])) {
                remember.add(nums[i]);
            }
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        return minOperations(nums, isUnique, minIdx, maxIdx);
    }
    static int minOperations(int[] nums, boolean isUnique, int minIdx, int maxIdx) {
        int cond = nums.length - 1;
        int operations = 0;

        if (isUnique && nums[maxIdx] - nums[minIdx] == cond) {
            return 0;
        }

        HashSet<Integer> remember = new HashSet<>();
        boolean isAnsPresent = false;

        for (int j = 0; j < cond + 1; j++) {
            if (nums[j] == nums[minIdx] + cond) {
                isAnsPresent = true;
                maxIdx = j;
                break;
            }
        }
        if (!isAnsPresent) {
            nums[maxIdx] = nums[minIdx] + cond;
            operations += 1;
        }

        for (int i = 0; i < cond + 1; i++) {
            if (remember.contains(nums[i]) || nums[i] >= nums[maxIdx] && i != maxIdx) {
                for (int j = 1; j < nums[maxIdx] - nums[minIdx] + 1; j++) {
                    int temp = nums[maxIdx] - j;
                    if (!remember.contains(temp)) {
                        nums[i] = temp;
                        remember.add(temp);
                        operations++;
                        break;
                    }
                }
            }
            else if (!remember.contains(nums[i])) {
                remember.add(nums[i]);
            }
        }
        return operations;
    }
}
