package SortingQuestions;

import java.util.Arrays;
/*
The first question in a contest that I solved all by my own.
My initial solution is in the comments below.
2ms, beats 100%.
 */
public class MinimumNumberGame {
    public static void main(String[] args) {
        int[] nums = {5,4,2,3};
        System.out.println(Arrays.toString(gameResult(nums)));
    }
    static int[] gameResult(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            int temp = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = temp;
        }
        return nums;
    }
}
/*
class Solution {
    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.sort(nums);
        int indexAlice = 1;
        int indexBob = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 != 0) {
               arr[indexBob] = nums[i];
                indexBob += 2;
            }
            else {
                arr[indexAlice] = nums[i];
            indexAlice += 2;
            }
        }
        return arr;
    }
}
 */