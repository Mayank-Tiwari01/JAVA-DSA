package BS;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 11, 7};
        int h = 8;
        // Sorting the piles array
        Sort(piles);
        // Displaying the sorted array
        System.out.println(Solution(piles, h));
    }

    static void Sort(int[] piles) {
        Arrays.sort(piles);
    }

    static int Solution(int[] piles, int h) {
        int start = 1;
        int end = piles[piles.length - 1];
        int sol = -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int sum = TimeTaken(piles, mid);
            if (sum < h){
                end = mid - 1;
            }
            else if(sum > h){
                start = mid + 1;
            }
            else{
                sol = mid;
                end = mid;
            }
        }
        return sol;
    }
    static int TimeTaken(int[] piles, int mid){
        int sum = 0;
        for(int nums: piles){
            sum += Math.ceil((double)nums / mid);
        }
        return sum;
    }
}