package MathematicsAndBitManipulation;
//https://www.youtube.com/watch?v=rCDKurGjTGg&list=TLPQMjkwNDIwMjSLsdb-W19_3A&index=2
public class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int i : nums)
            xor ^= i;

        int xorDif = (xor ^ k);
        xor = 0;

        while (xorDif > 0) {
            xor += xorDif & 1;
            xorDif >>>=1;
        }
        return xor;
    }
}