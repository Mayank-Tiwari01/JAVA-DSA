package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    //just like you lol. (sorry)
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleGuy(nums));
    }

    static int singleGuy(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int x = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                x = entry.getKey();
                break;
            }
        }
        return x;
    }
}
