package Recursion;
import java.util.*;
//n! Not sure.
public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        System.out.println(combine(n, k));
    }
    static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        allComb(n, k, new ArrayList<Integer>(), ans, 1);
        return ans;
    }
     static void allComb(int n, int k, List<Integer> ds, List<List<Integer>> ans, int start) {
        if (k == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (start > n)
            return;

        //take
        ds.add(start);
        allComb(n, k - 1, ds, ans, start + 1);

        //not take
        ds.remove(ds.size() - 1);
        allComb(n, k, ds, ans, start + 1);
        //if you did not take then k will remain as it is.
    }

}
