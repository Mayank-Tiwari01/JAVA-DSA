package DailyLeetcodeTries;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        int[] arr = {7,54,355,343,422,523,136,242,432,11,1,1,1,1,0};
        sortedByBits(arr);
        System.out.println(Arrays.toString(arr));;
    }
    static void sortedByBits(int[] arr) { // make it return int[] for leetcode.
        int len = arr.length;
        int[] bitsCount = new int[len];
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            int count = 0;
            int n = arr[i];
            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>= 1;
            }
            if (count > 1) flag = true;
            bitsCount[i] = count;
        }
        if (!flag) {
            Arrays.sort(arr);
            return;
        }
        sortByBits(arr, bitsCount);
    }
    static void sortByBits(int[] arr, int[] bitsCount) {
        int length = bitsCount.length;
        boolean swapped;

        for (int i = 0; i < length; i++) {
            swapped = false;
            for (int j = 0; j < length - i; j++) {
                if (j + 1 < length) {
                    if ( bitsCount[j] > bitsCount[j + 1] || (bitsCount[j] == bitsCount[j + 1] && arr[j] > arr[j + 1])) {
                        /*
                        Swap both the elements and their corresponding bit counts, What I did earlier was,
                        I just sorted the main array on the basis of the number of 1's they have but point to be noted is
                        that a value may be larger than a number and they can still have the same amount of 1's in their bits.
                         */
                        swap(arr, j, j + 1);
                        swap(bitsCount, j, j + 1);
                        swapped = true;
                    }
                }
            }
            if(!swapped){
                break;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
