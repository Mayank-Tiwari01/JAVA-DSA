//Input currency in rupees and output in USD.

import java.util.Scanner;

public class AssignmentQ6 {
    public static void main(String[] args) {

        System.out.println("Enter currency (in ruppes) : ");
        Scanner input = new Scanner(System.in);

        int rupees = input.nextInt();

        double dollars =  rupees / 82.5;

        String formattedDollars = String.format("%.2f", dollars);

        System.out.println("Equivalent amount in dollars: " + formattedDollars);

        input.close();
    }
}
