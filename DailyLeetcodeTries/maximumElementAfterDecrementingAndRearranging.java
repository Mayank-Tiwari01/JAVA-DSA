package DailyLeetcodeTries;

import java.util.Arrays;
/*
Even though I did not think about this question enough, but the O(log n) solution was very easy to think.
As India has qualified for the WC23 Final, don't think I will try to optimize it.
Runtime
6ms
Beats 82.14%of users with Java (pretty good, eh?)
 */
public class maximumElementAfterDecrementingAndRearranging {
    public static void main(String[] args) {
        int[] arr = {1000,100,1};
        System.out.println(maxElementAfterOperations(arr));
    }
    static int maxElementAfterOperations(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if ( arr[i + 1] - arr[i] > 1) {
                arr[i + 1] = arr[i] + 1;
            }
        }
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}
