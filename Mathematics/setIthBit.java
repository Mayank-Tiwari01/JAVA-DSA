package Mathematics;

public class setIthBit {
    public static void main(String[] args) {
        int n = 10;
        int iTh = 1;
        System.out.println(setBit(n, iTh));
    }
    static int setBit(int n, int iTh) {
        return n | (1 << (iTh - 1));
    }
}
