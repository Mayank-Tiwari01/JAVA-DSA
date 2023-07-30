package BS;

import java.util.Arrays;

public class TwoSumSortedTwoPointers {
    public static void main(String[] args) {
        int[] numbers = {-1,0};
        int target = -1;
        System.out.println(Arrays.toString(ans(numbers, target)));
    }
    static int[] ans(int[]numbers, int target){
        int start = 0;
        int end = numbers.length - 1;
        int[] ans = new int[2];

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                ans[0] = start + 1;
                ans[1] = end + 1;
                return ans;
            }
            else if(sum > target){
                end--;
            }
            else{
                start++;
            }
        }
        return ans;
    }
}
