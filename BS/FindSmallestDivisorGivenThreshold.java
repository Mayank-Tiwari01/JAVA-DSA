package BS;

import java.util.Arrays;

public class FindSmallestDivisorGivenThreshold {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(MinDiv(nums,threshold));

    }
    static int MinDiv(int[] x, int y){
        int start = 1;
        int end = Arrays.stream(x).max().getAsInt();
        //for(int num : nums) high = Math.max(num,high);

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(y < FindSum(x, mid)){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return start;
    }
    static int FindSum(int[] x, int y){
        int sum = 0;
        for (int j : x) {
            sum += Math.ceil(j / (float) y);
        }
        return sum;
    }
}
