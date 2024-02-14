package Recursion;
//class
public class towerOfHanoi {
    public static void main(String[] args) {
        moveDisk(3, 'a', 'b', 'c');
    }
    static void moveDisk(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 0)
            return;

        moveDisk(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        moveDisk(n - 1, aux_rod, to_rod, from_rod);
    }
}
