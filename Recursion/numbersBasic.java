package Recursion;

public class numbersBasic {
    public static void main(String[] args) {
        int n = 1;
       printNums(n);
    }
    static void printNums(int n) {
        if (n <= 21) {
            System.out.println(n);
            printNums(n + 2); // all odd numbers till 21
        }
    }
}
// mAgiC oF reCuRsIoN vRo