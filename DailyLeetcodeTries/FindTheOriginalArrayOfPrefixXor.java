package DailyLeetcodeTries;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[] pref = {5,2,0,3,1,90,0,1,34,12};
        System.out.println(Arrays.toString(findArray(pref)));
    }
    static int[] findArray(int[] pref) {
        int length = pref.length;
        int[] ans = new int[length];
        ans[0] = pref[0];

        for (int i = 1; i < length; i++) {
            ans[length - i] = pref[length - i ] ^ pref[length - i - 1];
        }
        return ans;
    }
}
