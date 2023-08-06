package BS;

public class CapacityToShipPackagesWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,1,1};
        int days = 4;
        System.out.println(MinWeight(weights, days));

    }
    static int MinWeight(int[] weights, int days){
        int start = -1;
        int end = 0;
        for(int nums : weights){
            start = Math.max(nums, start);
            end += nums;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(NumberOfDays(weights, mid) <= days){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
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
