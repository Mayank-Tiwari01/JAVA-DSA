package MathematicsAndBitManipulation;

import java.util.HashMap;

/*
The intuition is clear the condition nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
will only satisfy when the reverse of the number
is increased or decreased exactly what the other pair got increased or decreased.
I hope you got that. So like 13 and 35 is a pair because when you reverse 13 and make it 31, it is
increased by 18 and when you reverse 35 and make it 53, it is also increased by 18.

Runtime 30 ms Beats 91.25% of users with Java
O(n + log(num)). log(num) is the complexity of reversing every digit.
Everything OG!
 */
public class CountNicePairsInArray1814 {
    public static void main(String[] args) {
        int[] nums = {442,112,142,947,242,211,423};
        System.out.println(nicePairs(nums));
    }
    static int nicePairs(int[] nums) {
        long count = 0; //if you use int, it may cause int overflow for the last test case.
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = 1_000_000_007;

        for (int num : nums) {
            int subtraction = num - reverseNum(num);
            map.put(subtraction, map.getOrDefault(subtraction, 0) + 1);
        }
        for (int i : map.values()) {
            count += (long) i * (i - 1) / 2;
        }
        return (int) (count % mod);
    }
    static int reverseNum(int num) {
       int reverse = 0;
       while (num > 0) {
           int digit = num % 10;
           reverse = reverse * 10 + digit;
           num /= 10;
       }
       return reverse;
    }
}
