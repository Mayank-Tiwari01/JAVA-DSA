package DailyLeetcodeTries;
//will require concepts like dp, recursion, memorization or greedy.
//not complete.
public class MaxDotProductTwoSubsequences {
    public static void main(String[] args) {
        int[] nums1 = {2,1,-2,5};
        int[] nums2 = {3,0,-6};
        System.out.println(maxDotProduct(nums1, nums2));
    }
    static int maxDotProduct(int[] nums1, int[] nums2) {
        int maxProduct = 1;

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (maxProduct < nums1[i] * nums2[j]) {
                    maxProduct = nums1[i] * nums2[j];
                }
            }
        }
        return maxProduct;
    }
}
