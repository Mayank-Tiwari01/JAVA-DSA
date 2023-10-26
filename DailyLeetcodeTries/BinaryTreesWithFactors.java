package DailyLeetcodeTries;
// Understood the logic but it is a dp question.
import java.util.Arrays;
import java.util.HashMap;

public class BinaryTreesWithFactors {
    public static void main(String[] args) {
        int[] arr = {2, 4 , 8};
        System.out.println(numFactoredBinaryTrees(arr));
    }
    static int numFactoredBinaryTrees (int[] arr) {
        int mod = (int) Math.pow(10, 9) + 7;
        int count = arr.length;
        Arrays.sort(arr);
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i : arr) {
            set.put(i , 1);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int quotient = arr[i] / arr[j];
                    if (set.containsKey(quotient)) {
                        count += 1;
                    }
                }
            }
        }
        return count % mod;
    }
}
//        int ahead = 1;
//        int back = 0;

//        while (ahead < arr.length) {
//            if (arr[ahead] % arr[back] == 0) {
//                int req = arr[ahead] / arr[back];
//                if (set.contains(req)) {
//                    count++;
//                }
//            }
//            if (back != 0 && arr[ahead] % arr[back] != 0) {
//               back--;
//            }
//            else if (back == 0) {
//                ahead++;
//                back = ahead - 1;
//            }
//            else {
//                back--;
//            }
//        }

