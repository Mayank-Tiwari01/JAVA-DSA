package BS;

public class CapacityToShipPackagesWithinDays {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(MinWeight(weights, days));

    }
    static int MinWeight(int[] weights, int days){
        int start = 1;
        int end = 0;
        for(int nums : weights){
           end += nums;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(NumberOfDays(weights, mid) < days){
                end = mid - 1;
            }
            else if (NumberOfDays(weights, mid) > days){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int NumberOfDays(int[] weight, int mid){
        int counter = 1;
        int sum = 0;
        for(int nums : weight){
            if( sum + nums > mid){
                counter++;
                sum = nums;
            }
            else{
                sum += nums;
            }

        }
        return counter;
    }
}
