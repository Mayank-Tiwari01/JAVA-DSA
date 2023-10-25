package Mathematics;

class Solution {
    public static void main(String[] args) {
        int n = 12312;
        System.out.println(isPowerOfTwo(n));
    }
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0; // if there are more than one, 1, then the output won't be zero.
    }
}