package RecursionAndBacktracking;

public class stackOverflow {
    public static void main(String[] args) {
        fun(0);
    }
    static void fun(int n) {
//        if (n == 106) return;
        n++;
        System.out.println(n);
        fun(n);
    }
}
