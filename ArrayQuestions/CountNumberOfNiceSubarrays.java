package ArrayQuestions;

public class CountNumberOfNiceSubarrays {
    static int numberOfSubarrays(int[] nums, int k) {
        int[] map = new int[nums.length + 1];
        map[0] = 1;
        int count = 0, odd = 0;
        for (int i : nums) {
            if (i % 2 != 0)
                odd++;
            if (odd - k >= 0 && map[odd - k] != 0)
                count += map[odd - k];

            map[odd]++;
        }
        return count;
    }
}
