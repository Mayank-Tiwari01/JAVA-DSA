package Mathematics;
// a >> b = a / 2 ^b.
public class rightShiftOperator {
    public static void main(String[] args) {
        int n = 12;
        int rightShift = 1;
        System.out.println((float)(n >> rightShift)); // would not give answer in decimals.
        System.out.println((float) n / Math.pow(2, rightShift)); //would give answer in decimals.
    }
}
