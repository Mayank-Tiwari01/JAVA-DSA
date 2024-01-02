package ArrayQuestions2D;

import java.util.*;
import java.util.HashMap;
/*
suppose the array is 1,2,1,2,3,3,5.
if the num is 1 then we know its freq is zero (yet)
increase the freq++
so we add it in the list.
next num is 2, freq is 0 again
increase the freq++
so we add it in the list
the num is 1 now we know the freq is 1, that means there already exists a list with num 1.
so add a new list and then increase freq++.
how do we know which list to add?
if the freq is 2, then add it in the list with index 2, which means the 3rd list.
 */
public class ConvertArrayInto2DArrayWithConditions {
    public static void main(String[] args) {
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(convertIn2D(nums));
    }
    static ArrayList<List<Integer>> convertIn2D(int[] nums) {
        //Since 1 <= nums[i] <= nums.length (you can also use vector of size n to store frequency)
        int[] mp = new int[nums.length + 1];

        ArrayList<List<Integer>> result = new ArrayList<>();

        for (int c : nums) {

            if (mp[c] == result.size()) {
                result.add(new ArrayList<>());
            }
            result.get(mp[c]).add(c);
            mp[c]++;
        }

        return result;
    }
}
/*
another way :
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int i=0;
        int[] arr = new int[nums.length+1];
        for(int f: nums){
            arr[f]++;
            i = Math.max(i, arr[f]);
        }
        for(int j=0; j<i; j++){
            list.add(new ArrayList<>());
        }
        for(int f : nums){
            for(int j=0; j<i;j++){
                if(!list.get(j).contains(f)){
                    list.get(j).add(f);
                    break;
                }

            }
        }
        return list ;
    }
}
 */