package ArrayQuestions;
/*
the idea is we already know which indices we need for calculating median, so we will just search for them
instead of adding elements to an array, we will just increase a counter, and if that counter becomes equal to the indices
we need, then we update the value.
 */
public class MedianOfTwoSortedArraysConstantSpace {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(medianOfArrays(nums1, nums2));
    }
    static double medianOfArrays(int[] nums1, int[] nums2) {
        int mid1 = Integer.MAX_VALUE, mid2 = Integer.MAX_VALUE, count = 0;
        int p1 = 0, p2 = 0;
        int n1 = nums1.length, n2 = nums2.length, n3 = n1 + n2;
        int req1 = n3 / 2;
        int req2 = (n3 / 2)- 1;

        while (p1 < n1 && p2 < n2 && (mid1 == Integer.MAX_VALUE || mid2 == Integer.MAX_VALUE)) {
            if (nums1[p1] <= nums2[p2]) {
                if (count == req1) mid1 = nums1[p1];
                if (count == req2) mid2 = nums1[p1];
                p1++;
                count++;
            }
            else {
                if (count == req1) mid1 = nums2[p2];
                if (count == req2) mid2 = nums2[p2];
                p2++;
                count++;
            }
        }

        while (p1 < n1 && (mid1 == Integer.MAX_VALUE || mid2 == Integer.MAX_VALUE)) {
            if (count == req1) mid1 = nums1[p1];
            if (count == req2) mid2 = nums1[p1];
            p1++;
            count++;
        }

        while(p2 < n2 && (mid1 == Integer.MAX_VALUE || mid2 == Integer.MAX_VALUE)) {
            if (count == req1) mid1 = nums2[p2];
            if (count == req2) mid2 = nums2[p2];
            p2++;
            count++;
        }

        if (n3 % 2 == 0) {
            return (double) (mid1 + mid2) / 2;
        }
        return mid1;
    }
}
