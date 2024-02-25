package Recursion;

import java.util.*;
//Congratulations on doing this on your own. Not a big deal though.

public class PermutationWithSpaces {
    public static void main(String[] args) {
        String s = "ABCDE";
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        int[] temp = new int[s.length()];
        helper(s, ans, ds, 0, temp);
        System.out.println(ans);
    }

    static void helper(String s, List<String> ans, StringBuilder ds, int i, int[] temp) {
        if (i == s.length() - 1) { //-1 because we do not want space in the last.
            ds = new StringBuilder(); // Reset the StringBuilder for each permutation, avoid sharing the reference.
            for (int j = 0; j < s.length(); j++) {
                if (temp[j] == 1) {
                    ds.append(s.charAt(j));
                    ds.append(" ");
                } else {
                    ds.append(s.charAt(j));
                }
            }
            ans.add(ds.toString());
            return;
        }

        temp[i] = 1;
        helper(s, ans, ds, i + 1, temp);

        temp[i] = 0;
        helper(s, ans, ds, i + 1, temp);
    }
}