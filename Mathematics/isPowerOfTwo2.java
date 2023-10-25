package Mathematics;

public class isPowerOfTwo2 {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(Integer.toBinaryString(n));
        int counter = 0;
        while ( n > 0) {
            if ( (n & 1) == 1) {
                counter++;
            }
            n >>= 1;
        }
        System.out.println(counter == 1);
    }
}
