package SortingQuestions;

/*
perfectly fine code but chatgpt says there are unnecessary lines.
better written code is down below.
 */

import java.util.*;
public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4,8,5,7,6};

        System.out.println(Arrays.toString(sortEvenOdd(nums)));
    }
    static int[] sortEvenOdd(int[] nums) {
        int leftPointer = 0;
        int rightPointer = 1;

        while (rightPointer < nums.length && leftPointer < nums.length) {
            if (nums[leftPointer] % 2 == 0 && nums[rightPointer] % 2 != 0) {
                leftPointer++;
            }

            if (leftPointer == rightPointer) {
                rightPointer++;
            }

            else if (nums[leftPointer] % 2 != 0 && nums[rightPointer] % 2 == 0) {
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
            }

            else if (nums[leftPointer] % 2 != 0 && nums[rightPointer] % 2 != 0) {
                rightPointer++;
            }

            else if (nums[leftPointer] % 2 == 0 && nums[rightPointer] % 2 == 0) {
                rightPointer++;
                leftPointer++;
            }
        }
        return nums;
    }
}

/*
package SortingQuestions;

import java.util.*;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4, 8, 5, 7, 6};
        System.out.println(Arrays.toString(sortEvenOdd(nums)));
    }

    static int[] sortEvenOdd(int[] nums) {
        int leftPointer = 0;
        int rightPointer = 0;

        while (rightPointer < nums.length) {
            if (nums[rightPointer] % 2 == 0) {
                int temp = nums[leftPointer];
                nums[leftPointer] = nums[rightPointer];
                nums[rightPointer] = temp;
                leftPointer++;
            }
            rightPointer++;
        }

        return nums;
    }
}

 */
