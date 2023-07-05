//To calculate Fibonacci Series up to n numbers.

import java.util.Scanner;


public class AssignmentQ7 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int first = 0;
        int second = 1;

        while (true) {

            int next = first + second;

            if (next > num) {
                break;
            }

            first = second;
            second = next;

            System.out.println(next);

                    
        }

        input.close();
    }
    
}
