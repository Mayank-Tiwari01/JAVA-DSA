package Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllLonelyNumbersInTheArray {
    public static void main(String[] args) {
        int[] nums = {10,6,5,8};
        System.out.println(lonelyNums(nums));
    }
    static List<Integer> lonelyNums(int[] nums) {
        ArrayList<Integer> lonely = new ArrayList<>();
        HashMap<Integer, Integer> doesIt = new HashMap<>();

        for (int i : nums) {
            doesIt.put(i, doesIt.getOrDefault(i, 0) + 1);
        }

        for (int num : nums) {
            if (!doesIt.containsKey(num - 1) && !doesIt.containsKey((num + 1)) && doesIt.get(num) == 1 ) {
                lonely.add(num);
            }
        }
        return lonely;
    }
}

