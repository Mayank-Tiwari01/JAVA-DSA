package DailyLeetcodeTries;
import java.util.*;
/*
Note: could have found out the largest, smallest and could have added the elements in the set at the same time.
Also, this code gives TLE because I think it is written poorly. Have added leetcode answer at last.
 */
public class ArithmeticSubarraysBetter {
    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        System.out.println(isArithmeticList(nums, l , r));
    }
    static ArrayList<Boolean> isArithmeticList(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> isArithmetic = new ArrayList<>();

        for (int i = 0; i < l.length; i++) {
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            int tempLength = r[i] - l[i] + 1;
            int[] smallAndLarge = smallestAndLargest(temp, tempLength);
            isArithmetic.add(isArithmeticSubArr(temp, smallAndLarge[0], smallAndLarge[1], tempLength));
        }
        return isArithmetic;
    }

     static int[] smallestAndLargest(int[] temp, int length) {
        int[] smallAndLarge = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < length; i++) {
            if (temp[i] < smallAndLarge[0]) {
                smallAndLarge[0] = temp[i];
            }
            if (temp[i] > smallAndLarge[1]) {
                smallAndLarge[1] = temp[i];
            }
        }
        return smallAndLarge;
    }
    static boolean isArithmeticSubArr(int[] arr, int smallest, int largest, int length) {
        int diff = (largest - smallest) / (length - 1);
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        while (smallest < largest) {
            smallest += diff;
            if (!set.contains(smallest)) {
                return false;
            }
        }
        return true;
    }
}
/*
class Solution {
    public Boolean check(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int maxElement = Integer.MIN_VALUE;
        Set<Integer> arrSet = new HashSet();

        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
            arrSet.add(num);
        }

        if ((maxElement - minElement) % (arr.length - 1) != 0) {
            return false;
        }

        int diff = (maxElement - minElement) / (arr.length - 1);
        int curr = minElement + diff;

        while (curr < maxElement) {
            if (!arrSet.contains(curr)) {
                return false;
            }

            curr += diff;
        }

        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i] - l[i] + 1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i] + j];
            }

            ans.add(check(arr));
        }

        return ans;
    }
}

 */