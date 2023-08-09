package BS;
import java.util.Arrays;

public class MinimizeMaximumDifferencePairs {
    public static void main (String[] args){
        int[] nums = {1, 2, 2, 4, 4, 8};
        int p = 2;
        System.out.println(pairs(nums, p));
    }
    static int pairs(int[] nums,int p){
        Arrays.sort(nums);
        int first = 0;
        int second = 1;
        int lastValueWanted = p * 2 - 1;
        int minMaxDiff = 0;

        while(first < second && second <= lastValueWanted){
            minMaxDiff = Math.max(nums[second] - nums[first], minMaxDiff);
            first += 2;
            second += 2;
        }
        return minMaxDiff;
    }
}
