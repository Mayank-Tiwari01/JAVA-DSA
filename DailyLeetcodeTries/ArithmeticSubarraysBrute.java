package DailyLeetcodeTries;
import java.util.*;
/*
Brute force! 18 ms Beats 56.87% of users with Java
 O(m * n * (log(n) + n)) => O(m * n * logn)
 */
public class ArithmeticSubarraysBrute {
    public static void main(String[] args) {
        int[] nums = {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10};
        int[] l = {0,1,6,4,8,7};
        int[] r = {4,4,9,7,9,10};
        System.out.println(isArithmeticSubArr(nums, l , r));
    }
    static ArrayList<Boolean> isArithmeticSubArr(int[] nums, int[] l, int[] r) {
        ArrayList<Boolean> arithmeticSubArr = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            boolean isCont = true;
            int[] temp = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            // Arrays.stream(nums, l[i],r[i] + 1).toArray(); can be used too, but copyOfRange is more optimal.
            //because it directly creates a new array with the specified range without the overhead of stream operations.
            Arrays.sort(temp);
            int constDiff = temp[1] - temp[0];
            for (int j = 0; j < r[i] - l[i]; j++) {
               if (temp[j + 1] - temp[j] != constDiff) {
                   isCont = false;
                   break;
               }
            }
            arithmeticSubArr.add(isCont);
        }
        return arithmeticSubArr;
    }
}
