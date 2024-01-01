package ArrayQuestions;
/*
Runtime
2ms
Beats 72.12%of users with Java
try doing it with BS after some time.(Good luck with that btw)
 */
public class MedianTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,99,981,1111,22222};
        int[] nums2 = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,22,33,44,55,66,77,88,99,981,1111,22222,888888};
        System.out.println(medianOfArrays(nums1, nums2));
    }
    static double medianOfArrays(int[] nums1, int[] nums2) {
        int[] mergedArray = new int[nums1.length + nums2.length];
        int pointer1 = 0;
        int pointer2 = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            if (pointer1 < nums1.length && pointer2 < nums2.length && nums1[pointer1] <= nums2[pointer2]) {
                mergedArray[i] = nums1[pointer1];
                pointer1++;
            }
            else if (pointer1 < nums1.length && pointer2 < nums2.length && nums1[pointer1] > nums2[pointer2]) {
                mergedArray[i] = nums2[pointer2];
                pointer2++;
            }
            else if (pointer1 >= nums1.length && pointer2 < nums2.length) {
                mergedArray[i] = nums2[pointer2];
                pointer2++;
            }
            else if (pointer2 >= nums2.length && pointer1 < nums1.length) {
                mergedArray[i] = nums1[pointer1];
                pointer1++;
            }
        }

        //

        if (mergedArray.length % 2 != 0) {
            int index = (mergedArray.length) / 2;
            return (double) mergedArray[index];
        }
        double div = (double) (mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;
        return (double) div;
    }
}
/*
Remove Unnecessary Conditions:
for (int i = 0; i < mergedArray.length; i++) {
            if (pointer1 < nums1.length && (pointer2 >= nums2.length || nums1[pointer1] <= nums2[pointer2])) {
                mergedArray[i] = nums1[pointer1];
                pointer1++;
            } else {
                mergedArray[i] = nums2[pointer2];
                pointer2++;
            }
        }
 */


