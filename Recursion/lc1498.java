package Recursion;
//wrong ans lessgooo.
public class lc1498 {
    static int ans = 0;
    public static void main(String[] args) {
        int[] arr = {3,5,6,7};
        int target = 9;
        System.out.println(numSubseq(arr, target));
    }
    static int numSubseq(int[] nums, int target) {
        int len = nums.length;
        int[] arr = new int[len];
        subSeq(nums, 0, len, arr, target);
        return ans;
    }
    static void subSeq(int[] arr, int idx, int len, int[] temp, int target) {

        if (idx == len) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                if (temp[i] == 1) {
                    if (arr[i] < min) min = arr[i];
                    if (arr[i] > max) max = arr[i];
                }
            }
            if (min + max <= target) {
                ans++;
            }
            return;
        }

        //include a specific element
        temp[idx] = 1;
        subSeq(arr, idx + 1, len, temp, target);

        //exclude a specific element
        temp[idx] = 0;
        subSeq(arr, idx + 1, len, temp, target);
    }
}