package Mathematics;
// How many bits in binary representation of a number.
public class noOfBits {
    public static void main(String[] args) {
        int n = 1011;
        int temp = n;
        int count = 0;
        int base = 2; // for binary.
        while (temp > 0) {
            count++;
            temp >>= 1;
        }
        System.out.println(Integer.toBinaryString(n));
        System.out.println(count);
        System.out.println((int)(Math.log(n) / Math.log(base) + 1 )); //yea.
    }
}
