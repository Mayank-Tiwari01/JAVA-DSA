import java.util.Scanner;

public class Typecasting
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        char input = scanner.next().charAt(0);
        // // num = (int) (num);
        // byte b = (byte) (num); //if the value surpasses 256, it does num % 256
        // System.out.println(b);
        int intValue = (int) input;
        System.out.println(intValue);
        

    }
}