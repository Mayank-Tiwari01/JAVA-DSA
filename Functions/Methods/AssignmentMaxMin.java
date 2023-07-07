package Functions.Methods;

import java.util.Scanner;

public class AssignmentMaxMin {
    public static void main(String[] args) {
        System.out.println("Enter Numbers");
        maxMin();

    }

    public static void maxMin(){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        
        while((num = input.nextInt())!=0){
            if( num > max ){
                max = num;
            }
            else if(num < min){
                min = num;
            }

        }

        System.out.println("The maximum number is: " + max + ". And the minimum number is: " + min);

        input.close();
       

        
        
    }
}
