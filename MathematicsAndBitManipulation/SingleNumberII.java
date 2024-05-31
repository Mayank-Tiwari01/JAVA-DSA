package MathematicsAndBitManipulation;

public class SingleNumberII {
    static  int singleNumber(int[] nums) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                if ((num & (1 << i)) != 0) // == 1 will not work because
                    //The bitwise AND operation num & (1 << i) results in a number that is either 0 (if the i-th bit is
                    // not set) or 1 << i (if the i-th bit is set), not necessarily 1
                    count++;
            }
            if (count % 3 == 1)
                ans = ans | (1 << i);
        }
        return ans;
    }
}
