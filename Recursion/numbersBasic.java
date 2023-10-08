package Recursion;

public class numbersBasic {
    public static void main(String[] args) {
        int n = 1;
       printNums(n);
    }
    static void printNums(int n) {
        if (n <= 20) {
            System.out.println(n);
            printNums(n + 1);
        }
    }
}
// mAgiC oF reCuRsIoN vRo