package Mathematics;

public class posRightMostSetBit {
    public static void main(String[] args) {
        int n = 56453;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(posRight(n)); // 1 indexed.
        System.out.println(posRight1(n));
    }

    static int posRight(int n) {
        int twoSCompliment = 1 + (-n);
        int result =  n & twoSCompliment;
        int pos = 0;

        while (result > 0) {
            result >>= 1;
            pos++;
        }

        if ((n & 1) == 1) {
            return 1;
        } else {
            return pos;
        }
    }
    static int posRight1(int n) { //an inbuilt method.
        if (n == 0) {
            return 0; // No set bits in 0.
        }
        return Integer.numberOfTrailingZeros(n) + 1; // Adding 1 to make it 1-indexed.
    }
}
