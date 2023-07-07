import java.util.Scanner;

public class Prime2 {
    public static void main(String[] args) {
        System.out.println("Enter the Lower and Upper range");
        Scanner input = new Scanner(System.in);
        int lower = input.nextInt();
        int upper = input.nextInt();

        for (int i = lower; i <= upper; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }

        input.close();
    }

    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
