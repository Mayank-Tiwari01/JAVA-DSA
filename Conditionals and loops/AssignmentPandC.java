import java.util.*;

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

        for ( int i =1; i <= n; i++){
            nfactorial *= i;
            
        }

        for ( int i =1; i < r; i++){
            rfactorial *= i;
             

        }
        
        for ( int i =1; i < n_minus_r; i++){
             n_r_factorial *= i;
            
        }

        System.out.println("Select 0 for Permutation and 1 for Combination");
        int choice = input.nextInt();

        if(choice == 0){
            System.out.println("nPr: "+ nfactorial/n_r_factorial );
        }

        else if ( choice == 1){
            System.out.println("nCr: " + nfactorial / (n_r_factorial * rfactorial));
        }

        else{
            System.out.println("Please select 0 or 1");
        }

        input.close();

    }

}

// import java.util.Scanner;

// public class AssignmentPandC {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);

//         System.out.print("Enter n and r: ");
//         int n = input.nextInt();
//         int r = input.nextInt();

//         if (n < r) {
//             System.out.println("Invalid input. n should be greater than or equal to r.");
//             input.close();
//             return;
//         }

//         int nMinusRFactorial = 1;
//         int nFactorial = 1;
//         int rFactorial = 1;

//         for (int i = 1; i <= n; i++) {
//             nFactorial *= i;
//             if (i <= r) {
//                 rFactorial *= i;
//             }
//             if (i <= n - r) {
//                 nMinusRFactorial *= i;
//             }
//         }

//         System.out.println("Select 0 for Permutation and 1 for Combination");
//         int choice = input.nextInt();

//         if (choice == 0) {
//             int permutation = nFactorial / nMinusRFactorial;
//             System.out.println("nPr: " + permutation);
//         } else if (choice == 1) {
//             int combination = nFactorial / (nMinusRFactorial * rFactorial);
//             System.out.println("nCr: " + combination);
//         } else {
//             System.out.println("Invalid choice. Please select 0 or 1.");
//         }

//         input.close();
//     }
// }
