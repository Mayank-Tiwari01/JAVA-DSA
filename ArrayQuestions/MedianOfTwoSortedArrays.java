package ArrayQuestions;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7,8,9,99,981,1111};
        int[] nums2 = {1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17,18,22,33,44,55,66,77,88,99,981,1111,22222,888888};
        System.out.println(medianOfArrays(nums1, nums2));
    }
    static double medianOfArrays(int[] nums1, int[] nums2) {
        int a1 = nums1.length, a2 = nums2.length;
        int a3 = a1 + a2;
        int[] mergedArr = new int[a3];
        int p1 = 0, p2 = 0;

        for (int i = 0; i < a3; i++) { //better than using 3 different while loops. (written below)
            if (p1 < a1 && (p2 >= a2 || nums1[p1] <= nums2[p2])) {
                mergedArr[i] = nums1[p1];
                p1++;
            }else{
                mergedArr[i] = nums2[p2];
                p2++;
            }
        }

        if (a3 % 2 == 0) {
            return (double) (mergedArr[a3 / 2] + mergedArr[(a3/2) - 1]) / 2;
        }
        return mergedArr[a3/2];
    }
}
/*
        while(i < nums1.length && j < nums2.length){
            if(nums1[i]<nums2[j]){
                merged[count++] = nums1[i++];
            } else{
                merged[count++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            merged[count++] = nums1[i++];
        }
        while(j<nums2.length){
            merged[count++] = nums2[j++];
        }
 */