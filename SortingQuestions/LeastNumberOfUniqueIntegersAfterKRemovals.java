package SortingQuestions;
import java.util.*;
/*
Everything og ofc, made a mistake implementing hashmap, you should put the value/freq as 0 if the value is not present,
because it will get + 1 in the next line, also an edge case is if k is large enough to remove every digit, so put a check
before finally returning return (k >= 0) ? 0: len;
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(nums, k));
    }
    static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.putIfAbsent(j, 0);
            map.put(j, map.get(j) + 1);
        }
        int len = map.size();
        int[] freq = new int[len];
        int idx = 0;

        for (int key : map.keySet()) {
            freq[idx++] = map.get(key);
        }
        Arrays.sort(freq);

        for (int i = 0; i < len; i++) {
            if (k >= freq[i])
                k -= freq[i];
            else
                return len - i;
        }
        return (k >= 0) ? 0: len;
    }
}
