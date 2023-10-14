package Hashing;
import java.util.*;
public class SingleNumberIII {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2, 9};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
    static int[] singleNumbers(int[] nums) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int x = 0;
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                ans[index] = entry.getKey();
                index++;
            }
        }
        return ans;
    }
}

