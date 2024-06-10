package SortingQuestions;

public class HeightChecker1 {
    static int heightChecker(int[] heights) {
        int[] sorted = countSort(heights);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i])
                count++;
        }
        return count;
    }
    static int[] countSort(int[] heights) {
        int max = -1;
        for (int i : heights) max = Math.max(max, i);

        int[] countArr = new int[max + 1];

        for (int i : heights) countArr[i]++;

        for (int i = 1; i < max + 1; i++)
            countArr[i] = countArr[i - 1] + countArr[i];

        int[] sortedArr = new int[heights.length];
        /*
            Iterate from end of the input array and because
            traversing input array from end preserves the order of equal elements,
            which eventually makes this sorting algorithm stable.
        */

        for (int i = heights.length - 1; i >= 0; i--) {
            if (countArr[heights[i]] > 0) {
                sortedArr[countArr[heights[i]] - 1] = heights[i];
                countArr[heights[i]]--;
            }
        }
        return sortedArr;
    }
}
