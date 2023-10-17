package Mathematics;

public class posRightMostSetBit {
    public static void main(String[] args) {
        int n = 212; //11010100
        System.out.println(posRight(n));
    }
    static int posRight(int n) {
        int twoSCompliment = 1 + (-n);
        //00101011
        int result = n & twoSCompliment;
        //00000100
        int pos = 0;
//        return (int)(Math.log10(result) / Math.log10(2)) + 1; //can also do this.

        while (result > 0) {
            result >>= 1; //100 >> 10 (count 1), 10 >> 1 (count 2), 1 >> 1 (count 3)
            // after this, the loop breaks cause the rest of the number is less than 0.
            pos++;
        }
        return pos; // for 0 index return pos - 1;
    }
}
