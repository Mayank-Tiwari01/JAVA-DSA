package StackAndQueue;
import java.util.*;
public class IPO {
    static class Project {
        int profit;
        int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-heap to store projects based on their capital requirement
        PriorityQueue<Project> minCapitalHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.capital));

        // Max-heap to store projects based on their profit
        PriorityQueue<Project> maxProfitHeap = new PriorityQueue<>((p1, p2) -> p2.profit - p1.profit);

        // Add all projects to the min-heap based on their capital requirement
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.add(new Project(profits[i], capital[i]));
        }

        // Loop until we have undertaken k projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with the current capital to the max-heap
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().capital <= w) {
                maxProfitHeap.add(minCapitalHeap.poll());
            }

            // If there are no projects that can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }

            // Undertake the project with the maximum profit
            w += maxProfitHeap.poll().profit;
        }

        return w;
    }
}
