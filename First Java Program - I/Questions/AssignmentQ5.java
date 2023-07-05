//Take 2 numbers as input and print the largest number.

import java.util.Scanner;

public class AssignmentQ5 {
    public static void main(String[] args) {
        System.out.println("Enter first number");
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();

        System.out.println("Enter second number");
        int num2 = input.nextInt();

        if(num1 > num2){
            System.out.println(num1);
        }

        else if(num1<num2){
            System.out.println("\n"+ num2);
        }

        else{
            System.out.println("Both are equal");
        }

        input.close();

    }
    
}
