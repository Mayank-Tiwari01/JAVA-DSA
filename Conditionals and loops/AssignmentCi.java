import java.util.Scanner;

public class AssignmentCi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter initial principal balance: ");
        double principal = input.nextDouble();

        System.out.print("Enter interest rate: ");
        double interestRate = input.nextDouble();

        System.out.print("Enter number of times interest applied per time period: ");
        int frequency = input.nextInt();

        System.out.print("Enter number of time periods elapsed: ");
        int timePeriods = input.nextInt();

        double compoundInterest = principal * Math.pow((1 + interestRate / frequency), (frequency * timePeriods));

        System.out.println("Final amount: " + compoundInterest);
    }
}
