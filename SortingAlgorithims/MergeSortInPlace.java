package SortingAlgorithims;

import java.util.Arrays;

public class MergeSortInPlace {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0,44,3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int[] arr,int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        mergeArrays(arr, low, mid, high);
    }
    static void mergeArrays(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] merged = new int[high - low + 1];
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j])
                merged[k++] = arr[i++];
            else
                merged[k++] = arr[j++];
        }

        while (i <= mid)
            merged[k++] = arr[i++];

        while (j <= high)
            merged[k++] = arr[j++];

        for (int l = low; l <= high; l++)
            arr[l] = merged[l - low]; // for ease, you can set introduce a new variable for indexing.
        //because in merged the number is stored as 0 indexed, but if you just write
        //arr[l] = merged[l] then l contains low, and low will not be 0 all the time,
        //so it might give IOB error.
        //  if (high + 1 - low >= 0) System.arraycopy(merged, 0, arr, low, high + 1 - low);
    }
}
