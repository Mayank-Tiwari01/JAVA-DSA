package Recursion;
import java.util.*;
public class CountInversions {
    public static void main(String[] args) {
        long[] arr = {8, 4, 2, 1};
        System.out.println(mergeSort(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }
    static long  mergeSort(long[] arr, int start, int end) {
        long count = 0;
        if (start >= end) {
            return count;
        }

        int mid = start + (end - start) / 2;
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);

        count += mergeArrays(arr, start, mid, end);

        return count;
    }
    static long mergeArrays(long[] arr, int start, int mid, int end) {
        //could have used an array here of size end - start + 1.
        ArrayList<Long> list = new ArrayList<>();
        long count = 0;
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                list.add(arr[i]);
                i++;
            }
            else {
                count += mid - i + 1; //the only point really.
                list.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            list.add(arr[i]);
            i++;
        }

        while (j <= end) {
            list.add(arr[j]);
            j++;
        }
        int idx = 0;
        for (int x = start; x <= end; x++) {
            arr[x] = list.get(idx++);
        }
        return count;
    }
}
