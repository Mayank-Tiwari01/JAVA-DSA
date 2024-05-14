package RecursionAndBacktracking;
import java.util.*;
public class subSeqWithGivenSum {
    public static void main(String[] args) {
        int[] nums= {1,2,1,0,1};
        int target = 5;
        subSeqWithKSum(nums, target);
    }
    static void subSeqWithKSum(int[] nums, int k) {
        ArrayList<List<Integer>> subSeq = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
//        temp.add(100);
        helper(nums, 0, k, temp, subSeq, 0);
        System.out.println(subSeq);
    }
    static void helper(int[] nums, int idx, int k, ArrayList<Integer> temp, ArrayList<List<Integer>> subSeq, int sum) {
        if (idx == nums.length) {
//            System.out.println(temp);
            if (sum == k) {
                System.out.println(temp);
                subSeq.add(new ArrayList<>(temp)); // Create a new ArrayList to avoid sharing the reference
                //If you just write temp, then you share the reference; that means if later you add something else
                //in that array list that something will be added to all the previous array lists,
                // as they share the same reference.
                // Uncomment above print comment to see that the last thing added
                //in the array list is an empty array list,
                // and that is why when you save that list to another list,
                //one change to any of the added list will be reflected on all the array lists.
            }
            return;
        }
        temp.add(nums[idx]);
        sum += nums[idx];
        helper(nums, idx + 1, k, temp, subSeq, sum);

        sum -= nums[idx];
        temp.remove(temp.size() - 1);

        helper(nums, idx + 1, k, temp, subSeq, sum); //using idx++ will not work because it will pass idx then do ++
        //Idx + 1.
        /*
        It would increment idx after its current value is used in the method call, potentially leading to incorrect results in subsequent recursive calls.
        Therefore, it's good practice to use idx + 1 or ++idx to explicitly convey the intention of incrementing before the method call.
         */
    }
}
/*
When you add temp directly to subSeq without creating a new ArrayList,
you are essentially adding a reference to the same
ArrayList every time.
As a result, when you later modify the temp ArrayList,
those changes are reflected in all the previously added lists in subSeq.
This is why you see the same list multiple times.

When you modify the ArrayList directly, it changes the content of that specific ArrayList.
However, when you add an ArrayList to another ArrayList (as a reference),
and then you modify the content of the added ArrayList,
those modifications will be reflected in all references to that ArrayList.
 */
