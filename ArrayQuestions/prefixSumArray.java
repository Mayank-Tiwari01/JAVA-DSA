package ArrayQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class prefixSumArray {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,100};
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
        System.out.println("Enter the Range as Left and Right");
        int left = input.nextInt();
        int right = input.nextInt();
        int rangeSum = 0;
        if (left == 0) {
            rangeSum = arr[right];
        }
        else if (right > arr.length || left == arr.length) {
            System.out.println("Please enter range withing 0 " + " and " + (arr.length - 1));
        }
        else {
            rangeSum = arr[right] - arr[left - 1];
        }
        System.out.println(rangeSum);
    }
}
