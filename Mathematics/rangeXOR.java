package Mathematics;

public class rangeXOR {
    public static void main(String[] args) {
        int a = 5;
        int b = 29;
        int ans = xor(b) ^ xor(a - 1);
        System.out.println(ans);
    }
    static int xor(int x) {
        // finds out XOR from 0 to x.
        if (x % 4 == 0) {
            return x;
        }
        if (x % 4 == 1) {
            return 1;
        }
        if (x % 4 == 2) {
            return x + 1;
        }
        return 0;
    }
}
