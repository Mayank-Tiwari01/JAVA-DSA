package ArreyYar;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args){
        int[] digits = {9,8,7,6,5,4,3,2,1}; // will fail for 9,8,7,6,5,4,3,2,1,0
        int n = digits.length;
        int num = 0;

        for (int digit : digits) {
            num = num * 10 + digit;
        }

        num = num + 1;

        ArrayList<Integer> ansList = new ArrayList<>();

        while(num > 0){
            int temp = num % 10;
            ansList.add(temp);
            num = num / 10;
        }

        int[] ans = new int[ansList.size()];
        int j = 0;

        for ( int i = ansList.size() - 1; i >= 0; i--){
            ans[j] = ansList.get(i);
            j++;
        }

        System.out.println(Arrays.toString(ans));

        // class Solution {
        //     public int[] plusOne(int[] digits) {
        //         int n = digits.length;
        
        //         // Iterate from the rightmost digit
        //         for (int i = n - 1; i >= 0; i--) {
        //             // Add 1 to the current digit
        //             digits[i] += 1;
        
        //             // If the digit becomes 10, set it to 0 and carry over the 1
        //             if (digits[i] == 10) {
        //                 digits[i] = 0;
        //             } else {
        //                 // No carry over, return the modified array
        //                 return digits;
        //             }
        //         }
        
        //         // If all digits become 0, create a new array with an additional leading 1
        //         int[] newDigits = new int[n + 1];
        //         newDigits[0] = 1;
        //         return newDigits;
        //     }
        // }
        
    }
}
