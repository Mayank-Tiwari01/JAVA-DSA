//Fibonacci Series In Java Programs

import java.util.Scanner;

public class FibonacciSeries1 {
    public static void main(String[] args) {
        
        System.out.println("Until which number you want the Fibonacci series\n");
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        int first = 0;
        int second = 1;
        int next = 0;

        while (true){

            next = first + second;

            if (next > num){
                break;
            }

            int temp = second;
            second = next;
            first = temp;
            
            System.out.println( next);         

        }
              

        
    }
    
}
