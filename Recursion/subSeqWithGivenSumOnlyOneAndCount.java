package Recursion;

import java.util.ArrayList;

public class subSeqWithGivenSumOnlyOneAndCount {
    public static void main(String[] args) {
        int[] nums= {1,1,2,0};
        int k = 2;
        printOnlyOneSubSeq(nums, 0, k, new ArrayList<>(), 0);
        System.out.println(count(nums, 0, k, new ArrayList<>(), 0));
    }
    static boolean printOnlyOneSubSeq(int[] nums, int idx, int k, ArrayList<Integer> temp, int sum) {
        if (idx == nums.length) {
            if (sum == k) {
                System.out.println(temp);
                return true;
            }
            return false;
        }

        temp.add(nums[idx]);
        sum += nums[idx];
        if (printOnlyOneSubSeq(nums, idx + 1, k, temp, sum)) return true;

        sum -= nums[idx];
        temp.remove(temp.size() - 1);

        return (printOnlyOneSubSeq(nums, idx + 1, k, temp, sum));
    }
    static int count(int[] nums, int idx, int k, ArrayList<Integer> temp, int sum) {
        if (idx == nums.length) {
            if (sum == k) {
                return 1;
            }
            if (sum > k) return 0; //if values are positive.
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
