package MathematicsAndBitManipulation;

public class FindThePivotInteger {
    public static void main(String[] args) {
        int n = 8;
    }
    static int pivotInteger(int n) {
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            preSum[i] = sum;
        }
        for (int i = 1; i < n + 1; i++) {
            if (preSum[i] == sum - preSum[i - 1])
                return i;
        }
        return -1;
    }
}
