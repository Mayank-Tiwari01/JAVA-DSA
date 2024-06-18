package SortingQuestions;
//optimal for the constraints, also an OG solution.
//try with binary search and sorting too
public class MostProfitAssigningWork {
    static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int maxWorkerDiff = 0;

        for (int i : worker)
            maxWorkerDiff = Math.max(maxWorkerDiff, i);

        int[] maxProCount = new int[maxWorkerDiff + 1];
        for (int i = 0; i < difficulty.length; i++) {
            if (difficulty[i] <= maxWorkerDiff)
                maxProCount[difficulty[i]] = Math.max(profit[i], maxProCount[difficulty[i]]);
            //there can be duplicate difficulties with different profits.
        }
        int currentMax = 0;
        for (int i = 1; i <= maxWorkerDiff; i++) {
            currentMax = Math.max(currentMax, maxProCount[i]);
            maxProCount[i] = currentMax;
        }

        int totalProfit = 0;
        for (int i : worker) {
            totalProfit += maxProCount[i];
        }

        return totalProfit;
    }
}
