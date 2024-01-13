package Hashing;

import java.util.HashMap;
/*
Kinda like two sum but not
Because of -ve values, sliding window might not work.
So what we do is we keep adding and then see if that sum can be equals to k if we remove some previous part of the array
like 1,2,3,4,5,6. and K = 6. So add 1. 1 - 6 = -5. The sum -5 does not appear in the array, so we add the sum we have now
and also the amount/freq of times we found that sum. So 1 => 1. Now add 1 + 2 = 3. 3 - 6 = -3. Not present so add the sum
and freq of sum in HashMap 3 => 1. Now, 3 + 3 = 6. 6 - 6 = 0. As you can see, we found 6, but our logic will fail here
as we do not have a 0 in our map. So it is better to add 0 in the beginning. 0 => 1. So how many subarrays can have 6 sums?
The amount of times the sum 0 appears? So 1 so far. Add 6 in the map. 6 => 1. Keep doing this now, the last sum would be
21. 21 - 6 = 15. Do we have 15 on the map? Yes! How many times? 1, so add 1. Total subarrays = 1 + 1 = 2.
https://www.youtube.com/watch?v=fFVZt-6sgyo&list=TLPQMTIwMTIwMjSWanj7BnRMKg&index=2
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = {-1,2,3,4,5,6,7,-9};
        int k = 12;
        System.out.println(findSubarrays(nums, k));
    }
    static int findSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int sum = 0, subArrays = 0;
        for (int i : nums) {
            sum += i;
            int temp = sum - k;
            if (prefixCount.containsKey(temp)) {
                subArrays += prefixCount.get(temp);
            }
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return subArrays;
    }
}
