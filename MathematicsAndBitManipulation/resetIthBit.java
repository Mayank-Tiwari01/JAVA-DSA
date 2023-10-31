package MathematicsAndBitManipulation;

public class resetIthBit {
    public static void main(String[] args) {
        int n = 10;
        int iTh = 4;
        /*
        1010 => 0010 which in decimal is 2.
         */
        System.out.println(resetBit(n, iTh));
    }
    static int resetBit(int n , int iTh) {
        int mask = ~(1 <<(iTh - 1));
        return n & mask;
    }
}
