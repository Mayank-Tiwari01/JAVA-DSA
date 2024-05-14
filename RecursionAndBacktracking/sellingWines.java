package RecursionAndBacktracking;

import java.util.Scanner;
//class.
public class sellingWines {
    static int maxCost(int[] wine, int cost, int counter, int i, int j) {
        if (i > j)
            return cost;
        else if (i == j) {
            cost += counter * wine[i];
            return cost;
        } else {
            int cost1 = counter * wine[i] + maxCost(wine, 0, counter + 1, i + 1, j);
            int cost2 = counter * wine[j] + maxCost(wine, 0, counter + 1, i, j - 1);
            cost += Math.max(cost1, cost2);
            return cost;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] wine = new int[n];

        for (int j = 0; j < n; ++j)
            wine[j] = scanner.nextInt();

        System.out.println(maxCost(wine, 0, 1, 0, n - 1));
    }
}
