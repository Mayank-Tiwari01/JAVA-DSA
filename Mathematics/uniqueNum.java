package Mathematics;

public class uniqueNum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2,3,1,7};
        System.out.println(unique(nums));
    }
    static int unique(int[] nums) {
        int unique = 0;

        for (int i : nums) {
            unique ^= i;
        }
        return unique;
    }
}
