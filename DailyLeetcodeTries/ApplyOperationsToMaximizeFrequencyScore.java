package DailyLeetcodeTries;
/*
It is a correct solution. But the tc is very bad. TC is O(NlogN + N^2). It passes 767 / 774 test cases.
Everything OG but took a lot of time to implement it, guess I should have understood the approach better and also writing
conditions for two pointers is always a bit difficult. Liked the problem though. Will try binary search.
 */
import java.util.Arrays;

public class ApplyOperationsToMaximizeFrequencyScore {
    public static void main(String[] args) {
        int[] nums = {2,6,8,1,3,11,2};
        long k = 5;
        System.out.println(maxFreq(nums, k));
    }
    static int maxFreq(int[] nums, long k) {
        int length = nums.length;
        if (length == 1) return 1;
        Arrays.sort(nums);
        int maxFreq = 1;
        for (int i = 0; i < length; i++) {
            maxFreq = Math.max(frequency(i, k , nums, length), maxFreq);
        }
        return maxFreq;
    }
    static int frequency(int targetIdx, long k, int[]nums, int length) {
        int first = targetIdx, second = targetIdx;

        while (k >= 0) {
            if (first - 1 >= 0 && second + 1 < length && (nums[second + 1 ] - nums[targetIdx]) > (nums[targetIdx] - nums[first - 1])
            || first > 0 && second == length - 1 || first == length - 1) {
                first--;
                k -= nums[targetIdx] - nums[first];
            }
            else {
                second++;
                k -= nums[second] - nums[targetIdx];
            }
            if (k >= 0 && first == 0 && second == length - 1) return length;
        }

        return (second - first); //because the above logic will calculate one extra frequency because we are letting
        //the logic run until k becomes negative.
    }
}
