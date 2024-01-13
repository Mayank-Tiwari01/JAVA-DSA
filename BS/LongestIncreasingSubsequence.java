package BS;
import java.util.*;
/*
https://youtu.be/dWmh3O8uX8A?si=9XECsK8FQaKDY6a8
what we do here (as far as I have understood) we like to keep the array increasing, but we want that every element that
we add should be smaller. I'll explain one:
if the array is 0,1,0,3,2,3.
We add 0, then there is 1, so we add it too, we have another 0 we do add it in 0th place, then we have 3. Currently,
the list looks like 0,1,3? Right now see what happens:
the next element is 2, and we add it at 2nd idx which is where 3 is. By doing so, we did not change the number of elements
in the list (which is our final answer) except we made it 0,1,2 so that there is a higher chance of getting a value larger
than 2? Made sense? Suppose we kept 3 now the next element would be 3 again, and we won't be able to add it because
we want strictly increasing, but if we kept 2, we could add 3 and make the list 0,1,2,3. Which will give us LIS.
We are just keeping our chances of finding a larger element. Go through the video again, I'd say.

I thought the reason behind the algorithm/why we are doing this myself (written above). This is what chatGPT has to
say:
Yes, you've captured the essence of the algorithm correctly. The key idea is to maintain a sequence in such a way that it increases the likelihood of finding a larger element in the future. By strategically replacing or adding elements based on their lower bounds, you're essentially preserving the potential for a longer increasing subsequence.

In simpler terms, it's like saying, "Given the elements I've seen so far, I want to make sure that the next element has a good chance of being larger than the previous ones, so let me adjust the sequence accordingly." This strategy increases the chances of finding a longer increasing subsequence in the array.

Your interpretation aligns well with the underlying logic of the algorithm. If you have any more questions or if there's anything specific, you'd like to discuss further, feel free to let me know!
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,0,7,5,4,3,2,0,1,4};
        System.out.println(lengthOfLIS(nums));
    }
    static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length); // that is the max, makes it a little more optimized.
        for (int num : nums) {
            int idx = findLowerBoundBS(list, num);
            if (idx >= 0) list.set(idx, num);
            else list.add(num);
        }
        return list.size();
    }
    static int findLowerBoundBS(ArrayList<Integer> list, int target) {
        /*
        Why lower bound?
        We want an increasing subsequence, and hence
        we want to eliminate the duplicates as well.
        Lower_bound returns the index of "next greater or equal to"
         */
        int len = list.size();
        int start = 0, end = len;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int temp = list.get(mid);
            if (temp == target) return mid;
            if (temp < target ) start = mid + 1;
            else end = mid;
        }
        return (start == len) ? -1 : start;
    }
}