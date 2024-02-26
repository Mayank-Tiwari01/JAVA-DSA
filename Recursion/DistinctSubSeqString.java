package Recursion;
import java.util.*;
public class DistinctSubSeqString {
    //I think it's a distinct subset.
    public static void main(String[] args) {
        String s = "zaz";
        System.out.println(moreSubsequence(s));
    }
    static List<String> moreSubsequence(String a) {
         char[] aCharArr = a.toCharArray();
         Arrays.sort(aCharArr);
         String sortedA = new String(aCharArr);

        List<String> subA = new ArrayList<>();
        distinctSub(sortedA, 0, subA, new StringBuilder());
        return subA;
    }

    static void distinctSub(String s, int idx, List<String> ans, StringBuilder ds) {
        ans.add(ds.toString());
        for (int i = idx; i < s.length(); i++) {
            if (i != idx && s.charAt(i) == s.charAt(i - 1)) continue;
            ds.append(s.charAt(i));
            distinctSub(s, i + 1, ans, ds);
            ds.deleteCharAt(ds.length() - 1);
        }
    }
}

