package SortingAlgorithims;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,1,2,3,4,7,8,9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
           // int pivot = placePivot(arr, low, high);
            int pivot = placePivotMiddleIndex(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }
    static int placePivot(int[] arr, int low, int high) {
        int i = low;//will search for a larger element
        int j = high;//will search for a smaller element.

        //int pivotIndex = low; //low is taken as the pivot index, however, you can choose the middle element to be
        //the pivot element to avoid the worst case n^2 scenario.

        while (i < j) {
            //find larger
            while(arr[i] <= arr[low] && i < high)
                i++;
            //find smaller
            while (arr[j] > arr[low] && j > low)
                j--;
            if (i < j)
                swap(arr, i, j);
        }
        swap(arr, low, j);//pivot placed at it's correct pos.
        return j;
    }
    static int placePivotMiddleIndex(int[] arr, int low, int high) {
        // Choose the middle element as the pivot
        int pivotIndex = low + (high - low) / 2;
        swap(arr, pivotIndex, high);
        int pivot = arr[high];
        int i = low - 1;
        //"i" will keep track of all the elements that are shorter than the pivot element, we will make sure
        //that elements on the left side of "i" are smaller than the pivot element.
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                if (i != j) swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
