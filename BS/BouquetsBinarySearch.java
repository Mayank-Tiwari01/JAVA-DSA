package BS;

public class BouquetsBinarySearch {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        int k = 1;
        int m = 3;
        System.out.println(minDays(bloomDay, k, m));
    }
    static int findMin( int[] bloomDay){
        int min = Integer.MAX_VALUE;
        for(int num : bloomDay){
            if(min > num){
                min = num;
            }
        }
        return min;
    }
    static int findMax( int[] bloomDay){
        int max = Integer.MIN_VALUE;
        for(int num : bloomDay){
            if(max < num){
                max = num;
            }
        }
        return max;
    }
    static int minDays(int[] bloomDay, int k, int m){
        int min = findMin(bloomDay);
        int max = findMax(bloomDay);
        if((long)k * (long) m > bloomDay.length){
            return -1;
        }
        int counter = 0;
        int numberOfBouquet = 0;
        int sol = -1;

        while(min <= max){
            int mid = min + (max - min) / 2;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] <= mid){
                    counter++;
                }
                else{
                    counter = 0;
                }
                if(counter == k){
                    numberOfBouquet++;
                    counter = 0;
                }
            }
            if(numberOfBouquet < m){
                min = mid + 1;
                numberOfBouquet = 0;
                counter = 0;
            }
            else if(numberOfBouquet > m){
                max = mid - 1;
                numberOfBouquet = 0;
                counter = 0;
            }
        }
        return min;
    }
}
//or
//public class Solution {
//    public int minDays(int[] bloomDay, int m, int k) {
//        int n = bloomDay.length;
//        if ((long) m * k > n) {
//            return -1; // Impossible case.
//        }
//
//        int left = 1;
//        int right = Arrays.stream(bloomDay).max().getAsInt();
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (canMakeBouquets(bloomDay, mid, m, k)) {
//                right = mid;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        return left;
//    }
//
//    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k) {
//        int bouquets = 0;
//        int flowers = 0;
//
//        for (int i = 0; i < bloomDay.length; i++) {
//            if (bloomDay[i] <= day) {
//                flowers++;
//                if (flowers == k) {
//                    bouquets++;
//                    flowers = 0;
//                }
//            } else {
//                flowers = 0;
//            }
//        }
//
//        return bouquets >= m;
//    }
//}
