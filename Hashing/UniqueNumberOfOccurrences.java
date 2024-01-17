package Hashing;

import java.util.HashMap;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 55, 5, 55, 1, 1, 12, 2};
    }

    static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> numCount = new HashMap<>();

        for (int i : arr) {
            numCount.put(i, numCount.getOrDefault(i, 0) + 1);
        }

        int[] nums = new int[1001];

        for (int key : numCount.keySet()) {
            int freq = numCount.get(key);
            if (nums[freq] > 0) return false;
            else nums[freq] = freq;
        }
        return true;
    }
}
