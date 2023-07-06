/*Write a program to print the sum of negative numbers, sum of positive even numbers and the sum of positive odd numbers from a list of numbers (N) entered by the user.
The list terminates when the user enters a zero. */

import java.util.Scanner;

public class AssignmentLast {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sumPositiveEven = 0;
        int sumPositiveOdd = 0;
        int sumNegative = 0;

        int num = input.nextInt();

        do{
            if(num > 0){
                if (num % 2 ==0){
                    sumPositiveEven += num;
                }
                else if( num % 2 != 0){
                    sumPositiveOdd += num;
                }
            }
            else{
                sumNegative += num;
            }

        }

        while((num = input.nextInt())!=0);

        System.out.println("Sum of positive even numbers: " + sumPositiveEven);
        System.out.println("Sum of positive odd numbers: " + sumPositiveOdd);
        System.out.println("Sum of negative numbers: " + sumNegative);

        
        input.close();
 
    } 
}
