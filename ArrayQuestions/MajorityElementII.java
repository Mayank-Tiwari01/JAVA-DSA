package ArrayQuestions;

import java.util.ArrayList;
/*
Modified Moore's voting algorithm for elements appearing more than n/3 times.
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,4,4,4,4,4,4,4,4,4,4,4,4,4,7,4,4,7,7,7,7,7};
        System.out.println(majorityElements(nums));
    }
    static ArrayList<Integer> majorityElements(int[] nums) {
        ArrayList<Integer> major = new ArrayList<>();
        int[] candidates = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int[] count = {0, 0};

        for (int i = 0; i < nums.length; i++) {

            /*if the first count is zero and the element is not yet present in the candidate array, then
            add that element in the candidate array and increase the count.*/

            if (count[0] == 0 && candidates[1] != nums[i]) {
                candidates[0] = nums[i];
                count[0]++;
            }
            else if (count[1] == 0 && candidates[0] != nums[i]) {
                candidates[1] = nums[i];
                count[1]++;
            }
            else if (candidates[0] == nums[i]) {
                count[0]++;
            }
            else if (candidates[1] == nums[i]) {
                count[1]++;
            }
            else {
                count[0]--;
                count[1]--;
            }
        }

        count[0] = 0;
        count[1] = 0;

        for (int i = 0; i < nums.length; i++) {
            if (candidates[0] == nums[i]) {
                count[0]++;
            }
            if (candidates[1] == nums[i]) {
                count[1]++;
            }
        }
        int occurrence = nums.length / 3;

        if (count[0] > occurrence) {
            major.add(candidates[0]);
        }
        if (count[1] > occurrence) {
            major.add(candidates[1]);
        }

        return major;
    }
}
/*
There can be only at max 2 elements that can appear more than n/3 times, let's say the number of elements is 10.
The 10/3 = 3 so how many elements can actually occur more than three times? 4 + 4 + 4? That is 12, but the total elements are 10 only
that is why we can never have more than 2 elements which are appearing more than n/3 times.

Two Candidates: The algorithm starts with two candidates and maintains only these two candidates throughout its execution.
This is a fundamental aspect of the algorithm. If there were more than two candidates, it would complicate the counting and
comparison process, making the algorithm less efficient and potentially incorrect.

Voting Mechanism: The algorithm operates on the principle of a voting mechanism where candidates "cancel out"
each other when they are not the same as the current element being processed.
This cancellation process allows the algorithm to identify potential majority elements efficiently.
However, it can only maintain two candidates because it's designed to handle a majority element that appears more than n/3 times.
 */