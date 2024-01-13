package Hashing;
import java.util.HashMap;
/*
I think you have to remember the trick/concept only.
Keep adding single values and keep % them with k. Now let's say we get 5 as a value, we move forward and then after adding
and doing % k if we find 5 again, then that would mean we added k somewhere.
Eg: 23,2,4,6,7. 23 % 6 = 5. Now we add. 23 + 2 % 6 = 1, do we have 1? No, then go ahead. 25 + 4 % 6 = 5. Have we seen 5 before?
Yes at index 0. So index of 4 = 2 - index of 23 = 0 = 2- 0 = 2, and we wanted subarray with size greater than 1. So return
true.
Also add 0 => -1 to avoid a single element being equal to sum k. Because we want larger than 1. All the values are +ve
so this works, revisit the concept, because I know I'll forget.
https://www.youtube.com/watch?v=fFVZt-6sgyo&list=TLPQMTIwMTIwMjSWanj7BnRMKg&index=2
 */
public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }
    static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = sum % k;

            if (map.containsKey(temp)) {
                if (i - map.get(temp) >= 2) return true;
            }
            else{
                map.put(temp, i);
            }

        }
        return false;
    }
}