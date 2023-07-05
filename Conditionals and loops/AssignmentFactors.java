//Input a number and print all the factors of that number (use loops).

import java.util.Scanner;

public class AssignmentFactors {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 1; i <= n ; i++) {

            if(n % i == 0){
                System.out.println(i);
            }
            
        }

        input.close();
    }
    
}
