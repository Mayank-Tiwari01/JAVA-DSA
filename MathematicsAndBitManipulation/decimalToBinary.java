package MathematicsAndBitManipulation;

public class decimalToBinary {
    public static void main(String[] args) {
        int n = 2908;
        System.out.println(binaryConversion(n));
    }
    static String binaryConversion(int n) {
        StringBuilder binary = new StringBuilder();

        while (n > 0) {
            int rem = n % 2;
            binary.append(rem);
            n = n / 2;
        }
        return binary.reverse().toString();
    }
}
