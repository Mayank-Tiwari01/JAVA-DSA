package SortingQuestions;

import java.util.Arrays;
/*
Accepted
Runtime
0ms
Beats 100.00% of users with Java
(pura logic + implementation is my own let's goooo.)
much better and simple written code at the end tho.
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5,6,7,8,0,0,0,0,0};
        int m = 8;
        int[] num2 = {1,3,5,9,10};
        int n = 5;

        System.out.println(Arrays.toString(mergeArray(num1, num2, m, n)));
    }
    static int[] mergeArray (int[] nums1, int[] nums2, int m, int n) {
        int length = m + n;
        int[] temp = new int[m];

        for (int i = 0; i < m; i++){
            temp[i] = nums1[i];
        }
        int tempPointer = 0; //temp array pointer
        int num2Pointer = 0;//num2 array pointer
        int i = 0; //main array pointer

        while (tempPointer < m || num2Pointer < n || i < nums1.length) {
            if(tempPointer >= m) {
                while ( i < length) {
                    nums1[i] = nums2[num2Pointer];
                    num2Pointer++;
                    i++;
                }
            }

            if(num2Pointer >= n) {
                while ( i < length) {
                    nums1[i] = temp[tempPointer];
                    tempPointer++;
                    i++;
                }
            }
            if (tempPointer < m && num2Pointer < n && nums2[num2Pointer] < temp[tempPointer]) {
                nums1[i] = nums2[num2Pointer];
                num2Pointer++;
                i++;
            }
            if (tempPointer < m && num2Pointer < n && nums2[num2Pointer] > temp[tempPointer]) {
                nums1[i] = temp[tempPointer];
                tempPointer++;
                i++;
            }
            if (tempPointer < m && num2Pointer < n && nums2[num2Pointer] == temp[tempPointer]) {
                nums1[i] = nums2[num2Pointer];
                nums1[i + 1] = temp[tempPointer];
                tempPointer++;
                num2Pointer++;
                i += 2;
            }
        }

        return nums1;
    }
}

/*
The provided code effectively merges two sorted arrays, num1 and num2, into a single sorted array.
It uses pointers and indices to compare and place elements from the arrays into the merged array.
The code is well-written and efficient, with a runtime of 0ms, beating 100% of Java users.
The time complexity of the code is O(m + n), where m and n are the lengths of the input arrays.
The space complexity is O(m), as a temporary array of length m is used.

 */

/*
static int[] mergeArray(int[] nums1, int[] nums2, int m, int n) {
        int i = m - 1; // Index for the last element of nums1
        int j = n - 1; // Index for the last element of nums2
        int k = m + n - 1; // Index for the last position of merged array

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        return nums1;
    }
}
 */