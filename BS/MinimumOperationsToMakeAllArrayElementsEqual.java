package BS;

import java.util.ArrayList;

public class MinimumOperationsToMakeAllArrayElementsEqual {
    public static void main(String[] args) {
        int[] nums = {2,9,6,3};
        int[] queries = {10,2,3,4,5,6,7,8,9};
        ArrayList<Long> result = Answer(nums, queries);
        System.out.println(result);
    }
    static ArrayList<Long> Answer( int[] nums,int[] queries){
        ArrayList<Long> answer = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int sub = 0;
            for ( int j = 0; j < nums.length; j++){
                sub += Math.abs(queries[i] - nums[j]);
            }
            answer.add(Math.abs((long)sub));
        }

        return answer;
    }
}
