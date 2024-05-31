package MathematicsAndBitManipulation;

public class SingleNumberIII {
    static int[] singleNumber(int[] nums) {
        int xor = 0;

        for (int num : nums) xor ^= num;
        int k = 0;
        //find out which bit is different, and based on that, we will divide numbers in two groups and apply
        //single number I logic.
        //watch code story with mik great explanation.
        while ((xor & 1) != 1) {
            xor >>= 1;
            k++;
        }
        int groupA = 0, groupB = 0;

        for (int num : nums) {
            if ((num & (1 << k)) != 0)
                groupA ^= num;
            else
                groupB ^= num;
        }
        return new int[] {groupA, groupB};
    }
}
