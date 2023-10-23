package CSESIntroductoryProblems;

import java.util.Scanner;

public class missingNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long temp = n;
        long sum = 0;
        while (temp > 1) {
            long n1 = in.nextLong();
            sum += n1;
            temp--;
        }
        System.out.println(missing(sum, n));
    }
    static long missing(long sum, long n) {
        long exSum = (n * (n + 1)) / 2;
        return exSum - sum;
    }
}
