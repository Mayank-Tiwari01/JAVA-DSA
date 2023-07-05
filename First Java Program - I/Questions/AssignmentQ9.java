//To find Armstrong Number between two given number.

import java.util.Scanner;

public class AssignmentQ9 {
    public static boolean isArmstrongNumber(int number) {
        int originalNumber = number;

        //number of digits in a number.
        int digits = String.valueOf(number).length();
        int sum = 0;

        while (number != 0) {
            int temp = number % 10;
            sum += Math.pow(temp, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static void findArmstrongNumbers(int start, int end) {
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");
        for (int number = start; number <= end; number++) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int start = input.nextInt();
        int end = input.nextInt();
        findArmstrongNumbers(start, end);
    }
   
}
