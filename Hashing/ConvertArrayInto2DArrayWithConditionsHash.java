package Hashing;

import java.util.*;
/*
suppose the array is 1,2,1,2,3,3,5. (Explaining the first codes)
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

public class ConvertArrayInto2DArrayWithConditionsHash {
    public static void main(String[] args) {
        int[] nums = {1,3,4,1,2,3,1};
        System.out.println(convertIn2D(nums));
    }
    static ArrayList<List<Integer>> convertIn2D(int[] nums) {
        ArrayList<List<Integer>> arr2D = new ArrayList<>();
        HashMap<Integer, Integer> numsCount = new HashMap<>();

        for (int num : nums) {
            int freq = 0;
            if (numsCount.containsKey(num)) freq = numsCount.get(num);

            if (freq == arr2D.size()) arr2D.add(new ArrayList<Integer>());arr2D.get(freq).add(num);
            numsCount.put(num, numsCount.getOrDefault(num, 0) + 1);
        }
        return arr2D;
    }
}


