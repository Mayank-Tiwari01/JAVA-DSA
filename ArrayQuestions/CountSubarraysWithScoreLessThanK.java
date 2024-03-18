package ArrayQuestions;
//Exactly same like 713. Subarray Product Less Than K
public class CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {

    }
    static long countSubarrays(int[] nums, long k) {
        int start = 0;
        long score = 0, count = 0;

        for (int i = 0; i < nums.length; i++) {
            score += nums[i];
            while (score * (i - start + 1) >= k) {
                score -= nums[start];
                start++;
            }
            count += i - start + 1;
        }
        return count;
    }
}
