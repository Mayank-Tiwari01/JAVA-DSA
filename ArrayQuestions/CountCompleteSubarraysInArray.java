package ArrayQuestions;
import java.util.*;
/*
Brute force is easy and almost everyone is doing that. The logic behind this O(n) approach
is when you find a window that is containing all the unique elements, then the rest of
the remaining elements can also be a valid ans, right? Think about it, if an array's size
is 10, and it has 4 unique elements, you found 4 unique numbers at index 5, now the remaining
5 elements + the subarray you found is also an ans right? This problem is not famous
at all so did not really get the idea but got it 60%. Now when you reach a complete subarray
iterate in it again and reduce the elements one by one, if after removing that element,
the uniqueness remains; then we found another subarray withing that subarray that is
complete, now this new subarray + the remaining elements will be a valid subarray.
Len - i(i is the end pointer of a complete subarray) this formula is the only important
thing in this logic.
See this sol : https://leetcode.com/problems/count-complete-subarrays-in-an-array/solutions/3845571/complete-subarrays-solution/
 */
public class CountCompleteSubarraysInArray {
    public static void main(String[] args) {
        int[] nums = {1,3,1,2,2};
        System.out.println(countCompleteSubarrays(nums));
    }
    static int countCompleteSubarrays(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) set.add(num);
        int unique = set.size();
        int ans = 0;
        int j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() == unique) {
                ans += len - i;
                map.put(nums[j], map.get(nums[j]) - 1);
                map.remove(nums[j], 0);
                j++;
            }
        }
        return ans;
    }

}
