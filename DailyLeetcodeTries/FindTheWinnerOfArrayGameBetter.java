package DailyLeetcodeTries;
/*
this will give TLE as well, not really better.
 */
public class FindTheWinnerOfArrayGameBetter {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7}; //arr of distinct integers
        int k = 2;
        System.out.println(winnerElement(arr, k));
    }
    static int winnerElement(int[] arr, int k) {
        int largest = findLargest(arr);
        if (arr.length <= k) {
            return largest;
        }
        int count = 0;
        while (count < k) {
            if (arr[0] < arr[1]) {
                count = 0;
                swapping(arr, 1, 0);
                count++;
                if (count == k) {
                    return arr[0]; //winner will always be at 0.
                }
            }
            if (arr[0] > arr[1]) {
                swapping(arr, 0, 1);
                count++;
                if (count == k) {
                    return arr[0];
                }
            }
            if (arr[0] == largest) {
                return largest;
            }
        }
        return  - 1;
    }
    static void swapping (int[] arr, int winner, int loser) {
        int save = arr[loser];
        arr[0] = arr[winner];
        int first = 1;
        int second = 2;
        while (second < arr.length) {
            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
            first++;
            second++;
        }
        arr[arr.length - 1] = save;
    }
    static int findLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}


