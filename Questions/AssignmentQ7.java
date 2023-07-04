//To calculate Fibonacci Series up to n numbers.

import java.util.Scanner;


public class AssignmentQ7 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        int first = 0;
        int second = 1;

        for(int i = 0; i != num; i++){
            int temp = i + 1;
            int series = i + temp;

            System.out.println(series);

            
        }
    }
    
}
