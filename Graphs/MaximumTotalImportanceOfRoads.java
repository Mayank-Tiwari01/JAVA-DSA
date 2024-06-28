package Graphs;
import java.util.*;
public class MaximumTotalImportanceOfRoads {
    static class Pair {
        int city;
        int score;

        public Pair(int city, int score) {
            this.city = city;
            this.score = score;
        }
    }
    static long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        long maxImp = 0;
        for (int[] road : roads) {
            freq[road[0]]++;
            freq[road[1]]++;
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.score).reversed());

        for (int i = 0; i < n; i++)
            maxHeap.offer(new Pair(i, freq[i]));

        int[] assignValue = new int[n];

        for (int i = n; i > 0; i--)
            assignValue[maxHeap.poll().city] = i;

        for (int[] road : roads)
            maxImp += (assignValue[road[0]] + assignValue[road[1]]);

        return maxImp;
    }
}
