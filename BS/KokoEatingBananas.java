package BS;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int h = 5;

        // Displaying the sorted array
        System.out.println(Solution(piles, h));
    }

    public static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;;
        int n = v.length;
        //find the maximum:
        for (int j : v) {
            maxi = Math.max(maxi, j);
        }
        return maxi;
    }

    static int Solution(int[] piles, int h) {
        int start = 1;
        int end = findMax(piles);
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
                end = mid - 1;
            }
        }
        return sol;
    }
    static int TimeTaken(int[] piles, int mid){
        int sum = 0;
        for(int nums: piles){
            sum += Math.ceil((double)nums / (double) mid);
        }
        return sum;
    }
}