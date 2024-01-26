package Recursion;

public class sumOfNNums {
    public static void main(String[] args) {
        int n = 0;
        int i = 10000;
        //parametrised version.
        sum(n, i);
        //functional recursion
        System.out.println(sum1(i));
        //formula O(1)
        System.out.println(i * (i + 1) / 2);
    }
    static void sum(int n, int i) {
        if (i < 1) {
            System.out.println(n);
            return;
        }
        sum(n + i, i - 1);
    }
    static int sum1(int i) {
        if (i == 0) return 0;
        return i + sum1(i - 1);
    }
}
