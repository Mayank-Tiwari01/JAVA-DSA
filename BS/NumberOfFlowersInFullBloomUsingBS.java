package BS;

import java.util.Arrays;
/*
I do not know why and how the BS is working here, why does this approach work is also not clear.
I did the brute force all on my own, but it gave TLE. FML.
Understand the bs now, check the comment below. Two jan 2024.(see the comments, I understood all that by myself.)
 */
public class NumberOfFlowersInFullBloomUsingBS {
    public static void main(String[] args) {
        int[][] flowers = {
                {1, 6},
                {3, 7},
                {9, 12},
                {4, 13}
        };

        int[] people = {2,3,7,11};
        System.out.println(Arrays.toString(fullBloomFlowers(flowers, people)));
    }
    static int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int m = flowers.length;
        int[] answer = new int[n];
        int[] startBlooming = new int[m];
        int[] endBlooming = new int[m];

        for (int i = 0; i < m; i++) {
            startBlooming[i] = flowers[i][0];
            endBlooming[i] = flowers[i][1] + 1;
            /*
            If we do not do +1 here, then we will incorrectly find the upper bound.For e.g.,the Ending array is 1,2,3,4,5
            we want to know how many flowers died before 3. That is 1 and 2 right? But since we are calculating the upper
            bound, it will return the index of element 4, and that means we are getting 1,2 and 3, we do not need 3.
            So we +1 to it, now the array is 2,3,4,5,6. now if we want to know the upper bound of 3, the function will
            again return index of 4 because the upper bound of 3 is 4, but now the index of 4 is 2 and that is exactly how
            many flowers died before 3. Now the question might come that why we did not do +1 in start array?
            The answer is simple, we want to include the value in case of start array. for e.g.,
            1,2,3,4 is the array, and we want to know how many flowers started blooming at three or after three
            now the function returns the index of element 4. which is 3, and that is correct.
            So the answer is in case of blooming or start, we want to include 3, because the visitor can see the flower
            at 3, but in case of end or stop blooming, we do not want to include 3, because the flower already stopped blooming
            and the visitor cannot see it. Hope it helped.
             */
        }
        Arrays.sort(startBlooming);
        Arrays.sort(endBlooming);

        for (int i = 0; i < n; i++) {
            int start = check(startBlooming, people[i]);
            int end = check(endBlooming, people[i]);

            answer[i] = start - end;
        }
        return answer;
    }
    static int check (int[] nums, int target) {
        int low = 0;
        int high = nums.length ;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                high = mid;
                /*
                wondering why not we did mid - 1?
                because
                that "mid" might be the ceiling.
                suppose we have elements like 1,2,3,4.
                we want to know how many flowers
                grew before 3. So we look for the ceiling that is 4, right?
                why do we do that because the index of
                4 (ceiling/ just one higher value from 3/upperbound)
                is the total number of flowers that bloomed before or during 3.
                */
            }
        }
        return low; // you can even return high. because in the end, both pointers will be pointing to one index only.
    }
}
