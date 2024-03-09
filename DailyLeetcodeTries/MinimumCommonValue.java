package DailyLeetcodeTries;

public class MinimumCommonValue {
    public static void main(String[] args) {

    }
    static int getCommon(int[] nums1, int[] nums2) {
        int pOne = 0, pTwo = 0;

        if (nums1[nums1.length - 1 ] < nums2[0] || nums2[nums2.length - 1] < nums1[0])
            return -1;

        while (pOne < nums1.length && pTwo < nums2.length)  {
            if (nums1[pOne] == nums2[pTwo])
                return nums1[pOne];
            if (nums1[pOne] < nums2[pTwo])
                pOne++;
            else
                pTwo++;
        }
        return -1;
    }
}
