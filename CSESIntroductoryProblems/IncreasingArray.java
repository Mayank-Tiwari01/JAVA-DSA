package CSESIntroductoryProblems;

import java.util.Scanner;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        long[] arr = new long[length];
        for (long i = 0; i < length; i++) {
            arr[(int) i] = input.nextLong();
        }
        System.out.println(minOperations(length, arr));
    }
    static long minOperations(int length, long[] arr) {
        if (length == 1) {
            return 0;
        }
        long operations = 0;
        int first = 0;
        int second = 1;

        while (second < length) {
            if (arr[first] > arr[second]) {
                long sub = arr[first] - arr[second];
                arr[second] += sub;
                operations += sub;
            }
            first++;
            second++;
        }
        return operations;
    }
}
