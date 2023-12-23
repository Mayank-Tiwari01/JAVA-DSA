package ArrayQuestions;
/*
approach and logic are 100 % mine, but I think I got the idea of transversing the array more than one from a sol?
anyway, sol is good and is pretty good.
Did this with no knowledge of greedy algorithm, or dp.
O(3n)
Runtime: 3 ms, faster than 79.95% of Java online submissions for Candy.
Memory Usage: 43.8 MB, less than 54.09% of Java online submissions for Candy.
 */
public class candyHard {
    public static void main(String[] args) {
        int[] ratings = {9,2,8,11,0,7,4,3,1};
        System.out.println(minCandies(ratings));
    }
    public static int minCandies(int[] ratings) {
        int len = ratings.length;
        int minCandies = 1;
        int[] candiesCount = new int[len];
        candiesCount[0] = minCandies;

        for (int i = 0; i < len; i++) {
            if (i + 1 < len && ratings[i] < ratings[i + 1]) {
                minCandies++;
                candiesCount[i + 1] = minCandies;
            }
            else if (i + 1 < len && ratings[i] >= ratings[i + 1]){
                minCandies = 1;
                candiesCount[i + 1] = minCandies;
            }
        }

        for (int j = len - 1; j >= 0; j--) {
            if (j - 1 >= 0 && ratings[j] < ratings[j - 1] && candiesCount[j] >= candiesCount[j - 1] ) {
                candiesCount[j - 1] = candiesCount[j] + 1;
            }
        }

        int sum = 0;
        for (int i : candiesCount) {
            sum += i;
        }

        return sum;
    }
}
