package Hashing;

import java.util.HashMap;
/*
Everything OG OFC, came up with the intuition pretty fast, but I forgot that my math is weak. So yeah.
The only number that cannot be made by 2 and 3 is 1
which is not that crazy,
so first see if the num is divisible by 3 or not because that is what we want
if not then see if the number is giving 1 as a remainder or 2 as a remainder. Like 10.
You can also num - 4 % 3 == 0 thing.
then at last, check if the num is giving remainder 0 when dividing by 2. If it is 1 return -1 and rest easy.
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static void main(String[] args) {
        int[] nums = {19,19,19,19,19,19,19,19,19,19,19,19,19};
        System.out.println(minOp(nums));
    }
    static int minOp(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int op = 0;
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        for (int value : map.values()) {
            if (value == 1) return -1;
            else if (value % 3 == 0) op += value / 3;
            else if (value % 3 == 2 || value % 3 == 1) op += (value / 3) + 1;
            else if (value % 2 == 0) op += value / 2;
        }
        return op;
    }
}
