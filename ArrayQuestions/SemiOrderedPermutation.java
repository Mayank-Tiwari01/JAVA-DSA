package ArrayQuestions;

public class SemiOrderedPermutation {
    public static void main(String[] args) {
        int[] nums= {8,7,6,5,4,3,2,1};
    }
    public int semiOrderedPermutation(int[] nums) {
        int first = -1, last = -1;
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == 1)
                first = i;
            else if (nums[i] == len)
                last = i;
        }

        int ans = first + (len - last - 1);
        return (first < last)? ans : ans - 1;
        //if last appears before first, that means we can swap both
        //of them, use only one swap and pass them both to their place.
    }
}
