package ArrayQuestions;
import java.util.*;
/*
O(N) approach, we store the num of elements with a particular frequency.
https://youtu.be/Nsp_ta7SlEk?si=OB06am7NQB7AA55W&t=536
https://youtu.be/O5v9Tqv2ZDA?si=Yh8Wtuf1-me1Eh4m&t=1182
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        System.out.println(findLeastNumOfUniqueInts(nums, k));
    }
    static int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        int unique = map.size();
        int len = arr.length;
        int[] freq = new int[len + 1];

        for (int key : map.keySet()) {
            freq[map.get(key)]++;
        }

        for (int i = 1; i < len + 1; i++) {
            if (freq[i] > 0) {
                int numOfElements = freq[i] * i;
                if (numOfElements <= k) {
                    k -= numOfElements;
                    unique -= freq[i];
                }
                else {
                    int posToDel = k / i;
                    unique -= posToDel;
//                    k-= posToDel * i;
                    return unique;
                }
            }
        }
        return unique;
    }
}