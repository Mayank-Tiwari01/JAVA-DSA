package DailyLeetcodeTries;

import java.util.Arrays;
import java.util.HashSet;
/*Time Limit Exceeded
59 / 62 testcases passed
3:40 AM.
 */
public class MinimumNumberOperationsMakeArrayContinuous4 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,98,98,99,101,103}; //100,97,94,91,88,85,82,79,76,73,70,67,64,61,58,55,52,49,46,43
        System.out.println(minOperations(nums));
    }
    static int minOperations(int[] nums) {
        int lengthOriginal =  nums.length;
        int count = 0;
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int[] uniqueArr = new int[hashSet.size()];
        int i = 0;
        for (int num1 : hashSet) {
            uniqueArr[i] = num1;
            i++;
        }
        Arrays.sort(uniqueArr);
        for (int k = 0; k < uniqueArr.length; k++) {
            int range = uniqueArr[k] + (lengthOriginal - 1);
            for (int j = k; j < uniqueArr.length; j++) {
                if (uniqueArr[j] <= range) {
                    count++;
                }
                if (uniqueArr[j] > range || j == uniqueArr.length - 1) {
                    ans = Math.max(count, ans);
                    count = 0;
                    break;
                }
            }
        }
        return lengthOriginal - ans ;
    }
}
