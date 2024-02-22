package Recursion;

import java.util.*;

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        helper(s, ans, ds, 0);
        System.out.println(ans);
    }
    static void helper(String s, List<String> ans, StringBuilder ds, int i) {
        if (i == s.length()) {
            ans.add(ds.toString().trim());
            return;
        }
        helper(s, ans, ds.append(s.charAt(i)), i + 1);
       helper(s, ans, ds.append(" "), i + 1);
    }
}
