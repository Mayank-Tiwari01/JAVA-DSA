package RecursionAndBacktracking;

import java.util.Arrays;

public class selectionSortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 2, 3, 444, 55, 1, 2, 3, 4, 1, 0, 9, 0, 9, 45, 6, 7};
        selectionSort(arr, 0, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr, int i, int len, int largestIdx) {
        if (len == 1)
            return;

        if (i == len) {
            int temp = arr[largestIdx];
            arr[largestIdx] = arr[len - 1];
            arr[len - 1] = temp;
            selectionSort(arr, 0, --len, 0);
            return;
        }

        if (arr[largestIdx] < arr[i])
            largestIdx = i;

        selectionSort(arr, i + 1, len, largestIdx);
    }
}