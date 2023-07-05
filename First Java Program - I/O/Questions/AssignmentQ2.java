// Take name as input and print a greeting message for that particular name.

import java.util.Scanner;

public class AssignmentQ2 
{
    public static void main(String[] args)
    {
        System.out.println("Please enter your name: ");
        Scanner input = new Scanner(System.in);
        
        String s = input.nextLine();
        System.out.println("Hello, " + s + ", hope you're having a wonderful day filled with joy and positivity. May your journey be filled with success and fulfillment. Remember to embrace each moment with a smile and cherish the beauty that surrounds you. Wishing you all the best in your endeavors. Have a fantastic day!");

        input.close(); 
    }

    
}
