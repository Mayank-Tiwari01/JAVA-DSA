package Mathematics;

public class twoSCompliment {
    public static void main(String[] args) {
        int n = 123;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(twosCompliment(n)));
    }
    static int twosCompliment(int n) {
        return 1 + ( ~ n );
    }
}
