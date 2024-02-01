package SortingAlgorithims;
import java.util.*;
/*
Using arr.length is essential here, because you are breaking down the array in two parts everytime.
Watch Abdul Bari's video on merge sort, it is too good.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,65,4,3,2,1,1,1,1,0,9,0};
        int len = arr.length;
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    static int[] mergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return mergeArrays(left, right);
    }
    static int[] mergeArrays(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0;
        int r = 0;
        int m = 0;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                merged[m] = left[l];
                l++;
            }
            else {
                merged[m] = right[r];
                r++;
            }
            m++;
        }

        while (l < left.length) {
            merged[m++] = left[l++];
        }
        while (r < right.length) {
            merged[m++] = right[r++];
        }
        return merged;
    }
}
