package Mathematics;
// a << b = a * 2^b.
public class leftShiftOperator {
    public static void main(String[] args) {
        int n = 3;
        int leftShift = 3;
        System.out.println(result(n, leftShift));
    }
    static long result(int n, int shift) {
        return (long) n << shift;
    }
}
