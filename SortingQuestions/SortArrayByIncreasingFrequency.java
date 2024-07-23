package SortingQuestions;
import java.util.*;
public class SortArrayByIncreasingFrequency {
    class pair {
        int value;
        int freq;

        public pair(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }
    int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<pair> pq = new PriorityQueue<>(
                Comparator.comparingInt((pair a) -> a.freq)
                        .thenComparing((pair a, pair b) -> Integer.compare(b.value, a.value))
        );


        for (int key : map.keySet())
            pq.offer(new pair(key, map.get(key)));

        int idx = 0;

        while (!pq.isEmpty()) {
            pair pop = pq.remove();

            while (pop.freq > 0) {
                nums[idx++] = pop.value;
                pop.freq--;
            }
        }
        return nums;
    }
}
