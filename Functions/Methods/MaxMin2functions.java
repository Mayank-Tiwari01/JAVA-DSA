package Functions.Methods;


import java.util.Scanner;

public class MaxMin2functions {
    public static void main(String[] args) {
        System.out.println("Enter three numbers");

       Scanner input = new Scanner(System.in);
       int num1 = input.nextInt();
       int num2 = input.nextInt();
       int num3= input.nextInt();

       int maximum = max(num1, num2, num3);
       int minimum = min(num1, num2, num3);

       System.out.println("The maximum number is: " + maximum);
       System.out.println("The minimum number is: " + minimum);

       input.close();
      

    }

    static int max(int num1, int num2, int num3){

        int max = num1;

        if (num2 > max) {
            max = num2;
        }
 
        else if (num3 > max) {
            max = num3;
        }
 
        return max;

    } 
    
    static int min( int num1, int num2, int num3){

        int min = num1;

        if( num2 < num1){
            min = num2;
        }

        else if( num3 < num1){
            min = num3;
        }

        return min;

    }
    

        
}
