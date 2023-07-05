//Area Of Circle Java Program

import java.util.Scanner;

public class AssignmentQ1{
    public static void main(String[] args) {
        System.out.print("Enter Radius of a Circle: ");

        try (Scanner input = new Scanner(System.in)) {
            float radius = input.nextFloat();

            System.out.println("The area of the Circle is: " + radius * radius * 22/7 + " Units.");
        }

        
    }
}