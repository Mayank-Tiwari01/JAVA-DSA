package CSESIntroductoryProblems;

import java.util.Scanner;

public class weirdAlgo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        printNums(n);
    }
    static void printNums (long n) {
        while (n != 1) {
            System.out.print(n + " ");
            if (n % 2 == 0) {
                n/= 2;
            }
            else {
                n *= 3;
                n += 1;
            }
        }
        System.out.println(1);
    }
}
