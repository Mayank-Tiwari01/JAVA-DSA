package RecursionAndBacktracking;

import java.util.Arrays;

public class reverseArrayRecursion {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        int len = arr.length;
        // using parameters.
        reverse(0, len - 1, arr);
        System.out.println(Arrays.toString(arr));
    }
    static void reverse (int i, int j, int[] arr) {
        if (i > j) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverse(i + 1, j - 1, arr);
    }
}
