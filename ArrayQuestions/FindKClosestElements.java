package ArrayQuestions;
import java.util.*;
/*
Not 100% OG. Sliding window came in my mind through comments.
The idea is the window with the least sum of abs diff is our subarray. There is a BS solution too, I think, where you
find the lower bound, will try later.
Even if you find equal differences in the next window, there is a chance you might get a smaller sum ahead, but you need
to make sure that if the sum is equal, we take the window which is appearing first.
 */
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,56,78,89,99,100};
        int k = 7;
        int x = 15;
        System.out.println(findClosestElements(arr, k, x));
    }
    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, len = arr.length;
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        int subEnd = -1, subStart = -1;
        boolean foundEqual = false;

        for (int i = 0; i < len; i++) {
            int diff = Math.abs(arr[i] - x);
            currSum += diff;

            if (i - start + 1 == k) {
                // Check the current window sum against the minimum sum
                if (currSum < minSum) {
                    minSum = currSum;
                    subStart = start;
                    subEnd = i;
                    foundEqual = false;
                } else if (currSum == minSum && !foundEqual) {
                    // Handle the case when the sum is equal
                    subStart = start - 1;
                    subEnd = i - 1;
                    foundEqual = true;
                } else if (currSum > minSum) {
                    // Break if the current sum exceeds the minimum sum
                    break;
                }
                // Move the window by subtracting the first element's contribution
                currSum -= Math.abs(arr[start] - x);
                start++;
            }
        }

        // Create a List with the k closest elements
        List<Integer> ans = new ArrayList<>();
        for (int i = subStart; i <= subEnd; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}
