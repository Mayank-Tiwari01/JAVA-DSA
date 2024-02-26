package Recursion;
import java.util.*;
//https://www.geeksforgeeks.org/problems/generate-binary-string3642/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
public class generateBinaryStringGFG {
    public static void main(String[] args) {
        String s = "111?10?1";
        System.out.println(generate_binary_string(s));
    }
    static List<String> generate_binary_string(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder binStr = new StringBuilder();
        helper(ans, binStr, s, 0);
        Collections.sort(ans);

        return ans;
    }
    static void helper(List<String> ans, StringBuilder ds, String s, int idx) {
        if (idx == s.length()) {
            ans.add(ds.toString());
            return;
        }

        if (s.charAt(idx) == '?') {
            ds.append('1');
            helper(ans, ds, s, idx + 1);
            ds.deleteCharAt(idx);

            ds.append('0');
            helper(ans, ds, s, idx + 1);
            ds.deleteCharAt(idx);
        }
        else {
            ds.append(s.charAt(idx));
            helper(ans, ds, s, idx + 1);
            ds.deleteCharAt(idx);
        }
    }
}
