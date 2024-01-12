package ArrayQuestions;

import java.util.HashSet;
//class
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,200,4,3,2,1};
        System.out.println(longestConsecutive(nums));
    }
    static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);

        int max = 0;
        for (int num : nums) {
            int temp = 0;
            if (!set.contains(num - 1)) {
                int x = num;
                while (set.contains(x)) {
                    temp++;
                    x++;
                }
            }
            max = Math.max(max, temp);
        }
        return max;
    }
}