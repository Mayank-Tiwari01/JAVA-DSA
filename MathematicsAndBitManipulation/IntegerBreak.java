package MathematicsAndBitManipulation;

import java.util.*;

public class IntegerBreak {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter any Number (Between 2 - 58): ");
        int n = input.nextInt();
        System.out.println("The Maximum Product of " + n + " is: " +maxProduct(n));
        input.close();
    }
    static int maxProduct(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int result = 1;

        while (n > 4) {
            result *= 3;
            n -= 3;
        }
        return result * n;
    }
}
