import java.util.Scanner;

public class AssignmentHCF {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num1 = input.nextInt();
        int num2 = input.nextInt();

        int smallerNumber = 0;
        int hcf = 0;

        if(num1 > num2){
            smallerNumber = num2;
        }
        else if (num2 > num1){
            smallerNumber = num1;
        }
        else if (num1 == num2){
            hcf = num1;
        }
        else{
            System.out.println("Invalid Numeric value entered");
        }

        
        for ( int i = 1; i <= smallerNumber; i++) {
            
            if (num1 % i == 0 && num2 % i == 0){

                if (i > hcf){

                    hcf = i;
                    
                }


            }
        }
        System.out.println(hcf);

        input.close();

       
    }
}
