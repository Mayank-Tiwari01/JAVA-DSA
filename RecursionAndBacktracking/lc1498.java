package RecursionAndBacktracking;

//TLE ans lessgooo. It's fucking exponential mate whatchu think.
//also read below why you cannot pass an integer and increase its count and expect it to make changes in the
//original place
public class lc1498 {
    private static final int mod = 1000000007;
    public static void main(String[] args) {
        int[] arr = {14,4,6,7,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,146,12,22,11,33,45,66,777,88,99,10,11,22,3};
        int target = 22;

        System.out.println(numSubseq(arr, target));
    }
    static int numSubseq(int[] nums, int target) {
        int len = nums.length;
        int[] arr = new int[len];
        int[] ans = new int[1];
        subSeq(nums, 0, len, arr, target, ans);
        ans[0] -= 1;
        return ans[0] % mod;
    }
    static void subSeq(int[] arr, int idx, int len, int[] temp, int target, int[] ans ) {

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
                ans[0] += 1;
                ans[0] = ans[0] % mod;
            }
            return;
        }

        //include a specific element
        temp[idx] = 1;
        subSeq(arr, idx + 1, len, temp, target, ans);

        //exclude a specific element
        temp[idx] = 0;
        subSeq(arr, idx + 1, len, temp, target, ans);
    }
}
/*
In your code, you're passing the ans variable to the subSeq method as a parameter. However, the changes made to ans inside the subSeq method are not reflected outside of that method. Java passes parameters by value, which means that a copy of the variable is passed to the method. Any changes made to the parameter inside the method do not affect the original variable in the calling code.

To address this issue, you can use an array or an object to pass a reference to the variable, allowing changes to be reflected outside of the method. In your case, you've attempted to use an array for this purpose, but there might be an issue with the array's scope.
 */