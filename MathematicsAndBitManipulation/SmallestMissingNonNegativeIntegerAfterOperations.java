package MathematicsAndBitManipulation;
import java.util.*;
public class SmallestMissingNonNegativeIntegerAfterOperations {
    static int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            int temp = (i % value + value) % value;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int ans = 0;

        while (true) {
            int rem = ans % value;
            if (map.containsKey(rem) && map.get(rem) > 0) {
                map.put(rem, map.get(rem) - 1);
                ans++;
            }
            else
                return ans;
        }

    }
}
