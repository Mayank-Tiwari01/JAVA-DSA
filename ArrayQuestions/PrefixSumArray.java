package ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class PrefixSumArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 100};
        System.out.println(Arrays.toString(arr));
        prefixSum(arr);
        rangeSum(arr);
    }

    static void prefixSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            arr[i] = sum;
        }
    }

    static void rangeSum(int[] arr) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Range as Left and Right:");
        int left = input.nextInt();
        int right = input.nextInt();
        int rangeSum = 0;
        if (left < 0 || right >= arr.length || left > right) {
            System.out.println("Invalid input. Please enter a valid range.");
        } else if (left == 0) {
            rangeSum = arr[right];
        } else {
            rangeSum = arr[right] - arr[left - 1];
        }
        System.out.println("Sum of the range: " + rangeSum);
    }
}
