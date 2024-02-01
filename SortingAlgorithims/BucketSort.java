package SortingAlgorithims;
//class
import java.util.*;

public class BucketSort {
    public static void bucketSortWithRanks(int[] arr) {
        int n = arr.length;

        ArrayList<Integer>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int value : arr) {
            int index = (value * n) / 360;
            buckets[index].add(value);
        }
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void printRankedMarks(int[] marks) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = marks.length;

        for (int value : marks) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank);
            }
            rank--;
        }

        System.out.println("Marks\tRank");
        for (int value : marks) {
            System.out.println(value + "\t\t" + rankMap.get(value));
        }
    }

    public static void main(String[] args) {
        int[] marks = {120, 250, 180, 90, 320, 60, 150, 300, 180, 250, 120, 60, 60, 2, 1, 300};

        System.out.println("Original marks array:");
        printArray(marks);
        bucketSortWithRanks(marks);

        printRankedMarks(marks);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
