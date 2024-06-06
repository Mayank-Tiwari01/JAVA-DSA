package Hashing;

import java.util.*;

public class DivideArrayInSetsOfKConsecutiveNumbers {
    static boolean isPossibleDivide(int[] hand, int groupSize) {
        int len = hand.length;

        if (len % groupSize != 0) return false;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : hand)
            map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList);

        for (int i : arrayList) {
            while (map.get(i) > 0) {
                if (!checkSeq(i, map, groupSize)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkSeq(int num, HashMap<Integer, Integer> map, int k) {
        for (int i = 0; i < k; i++) {
            if (!map.containsKey(num + i) || map.get(num + i) <= 0) {
                return false;
            }
            map.put(num + i, map.get(num + i) - 1);
        }
        return true;
    }
}
