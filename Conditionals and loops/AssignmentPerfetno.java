import java.util.Scanner;

public class AssignmentPerfetno {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        int sum = 0;

        for (int i = 1; i < num; i++) {
            
            if ( num % i == 0){
                sum += i;
                
            }
           
        }

        if (sum == num){
            System.out.println("Perfect number!");
        }
        else{
            System.out.println("Not a Perfect number.");
        }
        
        input.close();


    }
}
