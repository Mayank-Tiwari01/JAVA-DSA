package Recursion;

import java.util.Arrays;
//dry run this (class)
public class bubbleSortUsingRecursion {
    public static void main(String[] args) {
        int[] nums = {7,8,9,10,1,3,2,1,3,4,5,6};
//        bubbleSort(nums, nums.length);
        noLoop(nums, nums.length, 0);
        System.out.println(Arrays.toString(nums));

    }
    static void bubbleSort(int[] arr, int n)
    {
        if (n == 1) return;

        int count = 0;
        for (int i=0; i<n-1; i++)
            if (arr[i] > arr[i+1])
            {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                count += 1;
            }

        if (count == 0) return;
        bubbleSort(arr, n-1);
    }
    static void noLoop(int[] arr, int n, int i) {
        if (n == 1 || n == 0) return;

        //after each iteration you have to set the index to 0 so that it starts from the beginning again.
        if (i == n - 1) {
            noLoop(arr, n - 1, 0);
            return;
        }
        if (arr[i] > arr[i + 1]) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        noLoop(arr, n, ++i);
    }
}