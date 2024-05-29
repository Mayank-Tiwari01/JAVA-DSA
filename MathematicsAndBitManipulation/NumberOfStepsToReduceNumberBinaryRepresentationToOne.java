package MathematicsAndBitManipulation;

public class NumberOfStepsToReduceNumberBinaryRepresentationToOne {
    public static void main(String[] args) {

    }
    static int numStepsBruteForce(String s) {
        int steps = 0;
        StringBuilder str = new StringBuilder(s);

        while (str.length() > 1) {
            int end = str.length() - 1;
            if (str.charAt(end) == '0') {
                str.setLength(str.length() - 1); // Right shift
            } else {
                // Increment
                for (int i = str.length() - 1; i >= 0; i--) {
                    if (str.charAt(i) == '1') {
                        str.setCharAt(i, '0');
                    } else {
                        str.setCharAt(i, '1');
                        break;
                    }
                    if (i == 0) {
                        str.insert(0, '1');
                    }
                }
            }
            steps++;
        }
        return steps;
    }
    static int numStepsOptimal(String s) {
        int steps = 0;
        StringBuilder str = new StringBuilder(s);
        int carry = 0;

        // Iterate from the least significant bit to the most significant bit
        for (int i = str.length() - 1; i >= 1; i--) {
            // Current bit is '0'
            if (str.charAt(i) == '0') {
                if (carry == 0) {
                    steps++; // Right shift
                } else {
                    steps += 2; // Increment and right shift
                }
            }
            // Current bit is '1'
            else {
                if (carry == 1) {
                    steps++; // Just right shift
                } else {
                    carry = 1; // Increment results in carry
                    steps += 2; // Increment and right shift
                }
            }
        }

        return steps + carry;
    }
}
