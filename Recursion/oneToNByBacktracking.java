package Recursion;

public class oneToNByBacktracking {
    public static void main(String[] args) {
        back(11);
        back2(0);
    }
    static void back(int n) {
        if (n <= 1) return;
        n--;
        back(n);
        /*  n--;  writing it here will give stack overflow.
          because the program flow never reaches this line and thus the base case is
        */
        System.out.println(n);
    }
    static void back2(int n) {
        if (n >= 10) return;
        n++;
        back2(n);
        System.out.println(n);
    }
}
