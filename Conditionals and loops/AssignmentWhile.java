//Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop)

import java.util.Scanner;

public class AssignmentWhile {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int sum = 0;
         int n;

        while ( (n = input.nextInt()) != 0){
            
            sum = sum + n;

        }
        System.out.println(sum);
    }
    
}
