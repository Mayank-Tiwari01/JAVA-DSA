package ArrayQuestions;

public class GlobalAndLocalInversions {
    public static void main(String[] args) {
        int[] nums = {0,2,1};
    }
    static boolean isIdealPermutation(int[] nums) {
        //the most stupid. basic and would be to just find one global
        //inversion that is not a local inversion,
        //so for them to be equal, they all should be just local inversions
        //because all local inversions are global inversions
        //if we can find even one global inversion that is not local
        //we can just return false.
        //if any previous value is bigger than
        // a value which is at +2 place of its pos, that
        //means we found a ge that is not le
        int max = -1;

        for (int i = 0; i < nums.length - 2; i++) {
            max = Math.max(nums[i], max);
            if (max > nums[i + 2])
                return false;
        }
        return true;
    }
}