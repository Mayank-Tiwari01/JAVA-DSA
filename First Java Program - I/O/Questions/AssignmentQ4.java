//Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)

import java.util.Scanner;

public class AssignmentQ4 {
    public static void main(String[] args) {
        
        System.out.println("Enter Two numbers: ");
        Scanner input = new Scanner(System.in);

        int num1 = input.nextInt();
        int num2 = input.nextInt();


        System.out.println("Choose any one operator \n 1: +\n 2: -\n 3: *\n 4: /\n ");
        int choose = input.nextInt();
        

        if (choose == 1){
        
            System.out.println("\nThe Addition of the numbers is: " + (num1+num2));
        }

        else if (choose == 2){
        
            System.out.println("\nThe Subtraction of the two numbers is: " + (num1-num2));
        }

        else if(choose == 3){

            System.out.println("\nThe Multiplication of the two numvers is: " + (num1*num2));

        }

        else if(choose == 4){
        
            System.out.println("\nThe divion of the two numbers is: " + ((float) num1/num2));
            
        }

        else{
        
            System.out.println("Enter a valid operation");
        }

          input.close();


    }
    
}
