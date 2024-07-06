package MathematicsAndBitManipulation;

public class PassThePillow {
    static int passThePillow(int n, int time) {
        if (time < n) return time + 1;

        int div = time / (n - 1);
        int rem = time % (n - 1);
        if (div % 2 == 0)
            return rem + 1;
        else
            return n - rem;
    }
}
