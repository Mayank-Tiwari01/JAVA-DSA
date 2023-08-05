package BS;

public class MinimumNumberOfDaysToMakeBouquets {
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
    static int minDays(int[] bloomDay,int k, int m){
        int pointer = 0;
        int counter = 0;
        int numberOfBouquet = 0;
        int min = findMin(bloomDay);
        int max = findMax(bloomDay);
        while(min <= max){
            for( int i = 0; i < bloomDay.length; i++){
                if(bloomDay[i] - min == 0 || bloomDay[i] - min < 0){
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

            if(numberOfBouquet == m || numberOfBouquet > m){
                return min;
            }
            else{
                numberOfBouquet = 0;
                counter = 0;
            }
            min++;
        }

        return -1;
    }
}
