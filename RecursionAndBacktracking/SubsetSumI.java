package RecursionAndBacktracking;

import java.util.*;
//https://www.geeksforgeeks.org/problems/subset-sums2234/1
public class SubsetSumI {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
    }
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        findSubsetSums(arr, 0, 0, ans);
        Collections.sort(ans);
        return ans;
    }
    static void findSubsetSums(ArrayList<Integer> arr, int idx, int sum, ArrayList<Integer> ans) {
        if (idx == arr.size()) {
            ans.add(sum);
            return;
        }
        findSubsetSums(arr, idx + 1, sum + arr.get(idx), ans);

        findSubsetSums(arr, idx + 1, sum, ans);
    }
}

