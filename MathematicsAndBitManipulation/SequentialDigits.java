package MathematicsAndBitManipulation;
import java.util.*;
/*
Implementation is Og.
The Approach is taken from the top comment which said: Declare a string = "123456789" and think of a sliding window.
TC: O (upperRange - lowerRange + 1 * 9) which is O(UR - LR)
The space complexity of the implementation is O(1),
as it only uses a constant amount of space to store the result list and a few temporary variables.
 */
public class SequentialDigits {
    public static void main(String[] args) {
        int low = 1;
        int high = 999999999;
        System.out.println(sequentialDigits(low, high));
    }
    static List<Integer> sequentialDigits(int low, int high) {
        String nums = "123456789";
        int lowerRange = 0, upperRange = 0;
        int lowerTemp = low, higherTemp = high;

        while (lowerTemp > 0) {
            lowerTemp /= 10;
            lowerRange++;
        }
        while (higherTemp > 0) {
            higherTemp /= 10;
            upperRange++;
        }

        List<Integer> seqDigits = new ArrayList<>();

        for (int i = lowerRange; i <= upperRange; i++) {
            int start = 0;
            for (int end = 0; end < 9; end++) {
                if (end - start + 1 == i) {
                    int temp = Integer.parseInt(nums.substring(start, end + 1));
                    if (temp >= low && temp <= high)
                        seqDigits.add(temp);
                    start++;
                }
            }
        }
        return seqDigits;
    }
}

