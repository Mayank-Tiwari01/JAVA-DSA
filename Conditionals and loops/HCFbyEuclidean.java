import java.util.Scanner;

public class HCFbyEuclidean {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1 = input.nextInt();
        int num2 = input.nextInt();

        int smallerNumber = 0;
        int largerNumber = 0;
        int hcf = 0;
        

        if(num1 > num2){
            smallerNumber = num2;
            largerNumber = num1;
             
        }
        else if (num2 > num1){
            smallerNumber = num1;
            largerNumber = num2;
        }
        else if (num1 == num2){
            hcf = num1;
            System.out.println(hcf);
            System.exit(0);
           
        }
        else{
            System.out.println("Invalid Numeric value entered");
        }

        while ( largerNumber % smallerNumber != 0){
            int remainder = largerNumber % smallerNumber;

            largerNumber = smallerNumber;
            smallerNumber = remainder;
        }
        hcf = smallerNumber;
        
        System.out.println(hcf);
        


    }
}
