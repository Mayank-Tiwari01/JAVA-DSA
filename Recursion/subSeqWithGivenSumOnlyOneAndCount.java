package Recursion;

import java.util.ArrayList;

public class subSeqWithGivenSumOnlyOneAndCount {
    public static void main(String[] args) {
        int[] nums= {1,1,2,0};
        int k = 2;
        helper(nums, 0, k, new ArrayList<>(), 0);
        System.out.println(count(nums, 0, k, new ArrayList<>(), 0));
    }
    //debug it in the near future.
    static boolean helper(int[] nums, int idx, int k, ArrayList<Integer> temp, int sum) {
        if (idx == nums.length) {
            if (sum == k) {
                System.out.println(temp);
               //pass by reference fault or something.
                return true;
            }
            return false;
        }

        temp.add(nums[idx]);
        sum += nums[idx];
        if (helper(nums, idx + 1, k, temp, sum)) return true;

        sum -= nums[idx];
        temp.remove(temp.size() - 1);

        if (!helper(nums, idx + 1, k, temp, sum)) return false;

        return false;
    }
    static int count(int[] nums, int idx, int k, ArrayList<Integer> temp, int sum) {
        if (idx == nums.length) {
            if (sum == k) {
                System.out.println(temp);
                //pass by reference fault or something.
                return 1;
            }
            return 0;
        }

        temp.add(nums[idx]);
        sum += nums[idx];
        int yes = count(nums, idx + 1, k, temp, sum);

        sum -= nums[idx];
        temp.remove(temp.size() - 1);

        int no = count(nums, idx + 1, k, temp, sum);

        return yes + no;
    }
}
