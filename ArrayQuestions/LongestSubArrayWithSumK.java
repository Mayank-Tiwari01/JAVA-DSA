package ArrayQuestions;
/*
Test Cases Passed:
189 /193
Time Limit Exceeded
Your program took more time than expected.Expected Time Limit: 2.96sec
 */
public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {-13, 0, 6, 15, 16, 2, 15, -12, 17, -16, 0, -3, 19, -3, 2, -9, -6};
        int k = 15;
        System.out.println(longestSubArr(arr, k));
    }
    static int longestSubArr(int[] arr, int k) {
        int longest = 0, sum = 0;
        int left = 0, right = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    longest = Math.max(j - i + 1, longest);
                }
            }
        }
        return longest;
    }
}