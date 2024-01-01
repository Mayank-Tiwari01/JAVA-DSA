package BS;
import java.util.*;

public class MinimumNumberOperationsToMakeArrayContinuous {
    public static void main(String[] args) {
        int[] nums = {41,33,29,33,35,26,47,24,18,28};
        System.out.println(minOp(nums));
    }
    static int minOp(int[] nums) {
        int orgLen = nums.length;
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) unique.add(num);

        int newLen = unique.size(), idx = 0;
        int[] newArr = new int[newLen];
        for (int num : unique) newArr[idx++] = num;

        Arrays.sort(newArr);
        int minOp = Integer.MAX_VALUE;
        for (int i = 0; i < newLen; i++) {
            int target = newArr[i] + orgLen - 1;
            int outerIdx = findCeilingBS(newArr, target, i, newLen);

            if (outerIdx == -1) minOp = Math.min(orgLen - (newLen - i), minOp);
            else if(newArr[outerIdx] == target)  minOp = Math.min(orgLen - (outerIdx - i + 1), minOp);
            else minOp = Math.min(orgLen - (outerIdx - i), minOp);
        }
        return minOp;
    }
    static int findCeilingBS(int[] arr, int target, int left, int len) {
        int right = len - 1, result = -1;
        if (target > arr[len - 1]) return -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] >= target) {
                result = mid;
                right = mid - 1;
            }
        }
        return result;
    }
}