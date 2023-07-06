import java.util.Scanner;

public class AssignmentPandC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter n and r: ");
        int n = input.nextInt();
        int r = input.nextInt();

        int n_minus_r = n - r;

        int nfactorial = 1;
        int rfactorial = 1;
        int n_r_factorial = 1;

        for (int i = 1; i <= n; i++) {
            nfactorial *= i;
            if (i <= r) {
                rfactorial *= i;
            }
            if (i <= n_minus_r) {
                n_r_factorial *= i;
            }
        }

        System.out.println("Select 0 for Permutation and 1 for Combination");
        int choice = input.nextInt();

        if (choice == 0) {
            int permutation = nfactorial / n_r_factorial;
            System.out.println("nPr: " + permutation);
        } else if (choice == 1) {
            int combination = nfactorial / (n_r_factorial * rfactorial);
            System.out.println("nCr: " + combination);
        } else {
            System.out.println("Please select 0 or 1");
        }

        input.close();
    }
}
