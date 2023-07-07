import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        
        System.out.print(" Enter a number: ");

        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        boolean prime = prime(num);
        System.out.println(prime(num));

        input.close();

    }

    static boolean prime(int num){
        
        if(num ==1){
            return false;
        }

        int n = 2;
        while(n * n <= num){
            if(num % n == 0){
                return false;
            }
            n++;


        }
        return n * n > num;
    }
}
