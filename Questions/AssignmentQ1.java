//Write a program to print whether a number is even or odd, also take input from the user.
import java.util.Scanner;

public class AssignmentQ1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        number = number % 2;
        
        if (number == 0)
        {
            System.out.println("This is an even number");
           
        }

        else
        {
            System.out.println("This is an odd number");
        }
        
        
    }
    
}
