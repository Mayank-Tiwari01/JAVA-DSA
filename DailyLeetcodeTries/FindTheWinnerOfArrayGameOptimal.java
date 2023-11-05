package DailyLeetcodeTries;

public class FindTheWinnerOfArrayGameOptimal {
    public static void main(String[] args) {
        int[] arr = {2,1,3,5,4,6,7}; //arr of distinct integers
        int k = 2;
        System.out.println(winnerElement(arr, k));
    }
    static int winnerElement(int[] arr, int k) {
        int currentMax = arr[0];
        int count = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > currentMax) {
                currentMax = arr[i];
                count = 1;
            }
            else {
                count++;
            }
            if (count == k) {
                return currentMax;
            }
        }
        return currentMax;
    }
}