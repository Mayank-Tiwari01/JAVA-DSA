package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
/*
Probably the hardest recursive program there is to understand (been few hours learning recursion, ready for what comes next)
To understand it, pick a pen and paper and write the recursive tree, see how function is calling another function, it is
easy once you understand it. See the explanation in spiral classmate copy in the recursion section.
Time Complexity (TC): O(2^n)

The recursive function generates all possible subsets by making two recursive calls for each element in the array,
representing the choice of including or excluding the element in the subset.
As a result, the time complexity is exponential, specifically O(2^n), where n is the length of the array.
Space Complexity (SC): O(n)

The space complexity is determined by the depth of the recursion, which is the length of the array (n). The binary array temp has a space complexity of O(n), and the recursion stack also contributes to the space complexity. The depth of the recursion is at most n, leading to a space complexity of O(n).
 */
public class createAllSubSeqRecursion {
    //in real interviews, using global variables is discouraged maybe, so do not use it.
    static ArrayList<List<Integer>> allSubSeq = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        int len = arr.length;

        subSeq(arr, 0, len, new int[len]);
        System.out.println(allSubSeq);
    }
    static void subSeq(int[] arr, int idx, int len, int[] temp) {
        if (idx == len) {
            ArrayList<Integer> currSubSet = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                 if (temp[i] == 1) {
                    currSubSet.add(arr[i]);
                }
            }
            allSubSeq.add(currSubSet);
            return;
        }

        //include a specific element.
        temp[idx] = 1;
        subSeq(arr, idx + 1, len, temp);

        //exclude a specific element.
        temp[idx] = 0;
        subSeq(arr, idx + 1, len, temp);
    }
}
