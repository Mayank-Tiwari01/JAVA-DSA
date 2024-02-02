package StringsAndStringBuilder;
/*
Approach from :
https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/solutions/906645/o-n-solution-thought-process
Read the solution, I know you forgot the logic.
Just remember that both xMis and yMis need to be even or odd, they cannot be one even and another one odd.
Why so: because we have to make pairs, so if xMis is 2 and yMis is 4, 1-1 pair, and 2-2 pair, won't happen the other way.
Read the solution mentioned above to make sense of it all.
 */
public class MinimumSwapsToMakeStringsEqual {
    public static void main(String[] args) {
        String s1 = "xxyyxyx";
        String s2 = "xxxxyyy";
        System.out.println(minimumSwap(s1, s2));
    }
    static int minimumSwap(String s1, String s2) {
        int len = s1.length();
        //no need to check if both string lengths are equal or not
        //as the input constraint satisfies this condition.

        int xMis = 0, yMis = 0;

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y')
                xMis++;
            else if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x')
                yMis++;
        }

        //either both can be even or odd.
        if (xMis % 2 != yMis % 2)
            return -1;

        int ans = (xMis / 2) + (yMis / 2);

        //if both are odd, then one pair would have been left.
        if (xMis % 2 == 1)
            ans += 2;

        return ans;
    }
}
