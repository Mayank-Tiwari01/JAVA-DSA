package SortingQuestions;
import java.util.*;
//you can directly add an array in a 2d array, just mention the row index.
//also check if the first element and the third element have difference more than k or not.
public class DivideArrayIntoArraysWithMaxDifference {
    public static void main(String[] args) {
        int[] arr = {6,10,5,12,7,11,6,6,12,12,11,7};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(arr, k)));
    }
    static int[][] divideArray(int[] nums, int k) {
        int len = nums.length;
        int[][] ans = new int[len / 3][3];

        Arrays.sort(nums);
        int row = 0;

        for (int i = 0; i < len - 2; i++) {
            if (i % 3 == 0) {
                if (nums[i + 2] - nums[i] > k) {
                    return new int[][]{};
                }
                else {
                    int[] triplet = {nums[i], nums[i + 1], nums[i + 2]};
                    ans[row] = triplet;
                    row++;
                }
            }
        }
        return ans;
    }
}
