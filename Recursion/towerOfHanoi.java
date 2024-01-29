package Recursion;
//class
public class towerOfHanoi {
    public static void main(String[] args) {
        moveDisk(3, 'a', 'b', 'c');
    }
    static void moveDisk(int n, char a, char b, char c) {
        if (n == 0)
            return;

        moveDisk(n - 1, a, c, b);
        System.out.println("Move disk " + n + " from rod " + a + " to rod " + b);
        moveDisk(n - 1, c, b, a);
    }
}
