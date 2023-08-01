package BS;

import java.util.Arrays;

public class TwoSumSortedBS {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
        int target = 19;
        System.out.println(Arrays.toString(ans(numbers, target)));
    }
    static int[] ans(int[]numbers, int target){
        int[] ans = new int[2];
        int length = numbers.length;
        for(int i = 0; i < length - 1; i++){
            int start = i + 1;
            int end = length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                int find = target - numbers[i];
                if(numbers[mid] == find){
                    //we have added one cause the question says the array is 1 indexed.
                    ans[0] = i + 1;
                    ans[1] = mid + 1;
                    return ans;
                }
                else if(numbers[mid] < find){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}
