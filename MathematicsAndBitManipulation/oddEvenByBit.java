package MathematicsAndBitManipulation;

public class oddEvenByBit {
    public static void main(String[] args) {
        int n = 2455;
        System.out.println(evenOdd(n));
    }
    static String evenOdd(int n) {
        if ((n & 1) == 1) {
            return "Odd";
        }
        return "Even";
    }
}
