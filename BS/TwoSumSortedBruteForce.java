package BS;

import java.util.Arrays;

public class TwoSumSortedBruteForce {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 17;
        System.out.println(Arrays.toString(ans(numbers, target)));
    }
    static int[] ans(int[]numbers, int target){
        int[] ans = new int[2];
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
