package DailyLeetcodeTries;
import java.util.*;
//Add when 1, subtract when 0. If you find a reoccurring sum that means the number of 0 and 1 is equal.
//This question then becomes like lc question subarray sum equals k.
//https://www.youtube.com/watch?v=AcSWGXBu-Xo&t=752s
public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
    static int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        //to handle the case where the sum is 0.
        mp.put(0, -1);
        int sum = 0;
        int subArrayLength = 0;
        for (int i = 0; i < n; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (mp.containsKey(sum)) {
                subArrayLength = Math.max(subArrayLength, i - mp.get(sum));
            } else {
                mp.put(sum, i);
            }
        }
        return subArrayLength;
    }
}