package SortingQuestions;
//https://www.youtube.com/watch?v=K2IomuIFbPg
public class MinimumNumberOfCoinsToBeAdded {
    public static void main(String[] args) {
        int[] nums = {1,4,10};
        int target = 19;
        System.out.println(minimumAddedCoins(nums, target));
    }
    static int minimumAddedCoins(int[] coins, int target) {
//        Arrays.sort(coins);
        long maxReachable = 0;
        int count = 0, i = 0;

        while (maxReachable < target) {
            if (i < coins.length && (coins[i] - 1) <= maxReachable) {
                maxReachable += coins[i++];
            }
            else {
                maxReachable += (maxReachable + 1);
                count++;
            }
        }
        return count;
    }
}
