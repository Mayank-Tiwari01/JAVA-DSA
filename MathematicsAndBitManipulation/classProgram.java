package MathematicsAndBitManipulation;

public class classProgram {
    public static void main(String[] args) {
        int n = 11;
        int i = 4;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(clearIthBit(n, i));
    }
    static int getIthBit(int n, int i) {
        return n & (1 << (i - 1));
    }
    static int setIthBit(int n, int i) {
        return n | (1 << (i - 1));
    }
    static int clearIthBit(int n, int i) {
        return (n & (~(1 << (i - 1))));
    }
    static int updateIthBit(int n, int i, int update) {
        return n & (~(1 << i)) | update << i;
    }
    static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
        /*
        while(n){
        n &= (n-1);
        count++;
        }
         */
    }
    static int clearMSBthroughI(int n , int i, int range) {
        // To clear all bits from the most significant bit through i (inclusive), we do:
        int mask = (1 << i) - 1;
        return n & mask;
        //https://stackoverflow.com/questions/15816927/bit-manipulation-clearing-range-of-bits
    }
    static int clearBitsIthrough0(int n, int i) {
        // To clear all bits from i through 0 (inclusive), we do:
        //int mask = ~(((1 << (i+1)) - 1);
        int mask = -(1 << (i + 1));
        return n & mask;
        //https://stackoverflow.com/questions/15816927/bit-manipulation-clearing-range-of-bits
    }
}
