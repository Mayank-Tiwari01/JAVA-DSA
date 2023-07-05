import java.util.Scanner;

public class AssignmentLargest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int largest = Integer.MIN_VALUE;
        int n;

        while ((n = input.nextInt()) != 0) {
            if (n > largest) {
                largest = n;
            }
        }

        System.out.println("The largest number is: " + largest);

       input.close();
    }
}
