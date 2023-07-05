//Calculate Average Of N Numbers

import java.util.Scanner;

public class AssignmentAbg {
    public static void main(String[] args) {
        System.out.print("Number of Elements: ");
        
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter element no. " + i + ": ");
            int temp = input.nextInt();
            sum += temp;
        }

        double average = (double) sum / n;
        System.out.println("Average is " + average + ".");

        input.close();
    }
}


