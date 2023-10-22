package DailyLeetcodeTries;
/*
Accepted
Runtime
8ms
Beats 72.38%of users with a Java
read story below cause why not
 */
public class MaximumScoreOfGoodSubarrayGreedy {
    public static void main(String[] args) {
        int[] nums = {1,4,3,7,4,5};
        int k = 3;
        System.out.println(maxScore(nums, k));
    }
    static int maxScore(int[] nums, int k) {
        int l = k;
        int r = k;
        int min = nums[k];
        int maxS = nums[k];

        while (l >= 0 && r < nums.length) {
            if (l > 0 && r < nums.length - 1) {
                if (nums[l - 1] > nums[r + 1]) {
                    l -= 1;
                    min = Math.min(min, nums[l]);
                }
                else {
                    r += 1;
                    min = Math.min(min, nums[r]);
                }
                maxS = Math.max(maxS, (min * (r - l + 1)));
            }
            if (l == 0 && r == nums.length - 1) {
                break;
            }
            if (l == 0 && r < nums.length - 1) {
                r++;
                min = Math.min(min, nums[r]);
                maxS = Math.max(maxS, (min * (r - l + 1)));
            }
            if (l > 0 &&  r == nums.length - 1) {
               l--;
               min = Math.min(min, nums[l]);
               maxS = Math.max(maxS, (min * (r - l + 1)));
            }
        }
        return maxS;
    }
}
/*
Started writing this code on 22nd oct (ind vs nz, ind!!) and ended on 23rd oct.
The logic was not original, and I guess that is the reason it took me so long to actually implement it.
I guess I could have come up with the solution if I read and understood the question properly??
Even after knowing the logic, it took me a lot of hours to write this, IDK why.
Probably because I have already used all my brain juice in the cocubes test, and I am maybe tired and not fully focused.
But the commentator said one thing today about Virat The GOAT Kohli, that he is a very persistent player, persistent but in
a good way. And I am thinking of being the same, I did not quit and will not quit. Goodnight.
It's 2 AM and it is lonely.
 */