// Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
import java.util.Scanner;

public class AssignmentQ3 {
    public static void main(String[] args) {

        System.out.print("Enter Principle amount: ");
        Scanner input = new Scanner(System.in);
        int p = input.nextInt();

        System.out.print("Enter Time period: ");
        int t = input.nextInt();

        System.out.print("Enter Rate of Interest: ");
        float r = input.nextFloat();

         double si =  (p * r * t) / 100;

        System.out.println("Your Simple Interest at " + p + " Principle Amount and, " + t + " Time Period and " + r + " Rate of Interest is: " + si);
        double total_a = si + p;
        System.out.println("And Total amount after " + t + " years is: " + total_a);
        
        input.close();
        
    }
}
