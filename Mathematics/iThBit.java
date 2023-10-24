package Mathematics;

public class iThBit {
    public static void main(String[] args) {
        int n = 12;
        int iTh = 3;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(bit(n, iTh));
    }
    static int bit(int n, int iTh) {
        return n & (1 << (iTh - 1));
    }
}
