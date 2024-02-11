package SortingQuestions;
import java.util.*;
//gfg
public class RopeCutting {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,1};
        int n = arr.length;
        System.out.println(ropeCutting(arr, n));
    }
     static ArrayList<Integer> ropeCutting (int arr[], int n) {
        // Complete the Function
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int store = arr[i];
        while (i < n) {
            while (i < n && arr[i] - store <= 0)
                i++;

            if (n - i != 0) {
                ans.add(n - i);
            }
            store = (i < n) ? arr[i] : 0;
        }
        return ans;
    }
}
