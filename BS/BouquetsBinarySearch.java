package BS;

public class BouquetsBinarySearch {
    public static void main(String[] args) {
        int[] bloomDay = {1000000000,1000000000};
        int k = 1;
        int m = 1;
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

    }
}
