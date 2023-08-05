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
        int min = findMin(bloomDay);
        int max = findMax(bloomDay);
        int counter = 0;
        int numberOfBouquet = 0;

        while(min <= max){
            int mid = min + (max - min) / 2;
            for(int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] - mid <= 0){
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
            }
            else if(numberOfBouquet >= m){
                return min;
            }
        }
        return -1;
    }
}
