import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();
        System.out.println(evenOdd(num));
        
    }
    static boolean evenOdd(int num){

        if(num % 2 == 0){
            return true;
        }

        return false;

    }
}
