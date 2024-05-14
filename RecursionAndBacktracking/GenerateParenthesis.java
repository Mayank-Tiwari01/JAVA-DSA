package RecursionAndBacktracking;
import java.util.*;
//brute force would be to generate every possible patter and checking if it's valid or not.
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }
    static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        helper(ans, ds, 0, 0, n);
        return ans;
    }
    static void helper(List<String> ans, StringBuilder ds, int open, int close, int n) {
        if (open == n && close == n) {
            ans.add(ds.toString());
            return;
        }

        if (open < n) {
            ds.append('(');
            helper(ans, ds, open + 1, close, n);
            ds.deleteCharAt(ds.length() - 1);
        }
        if (close < open) {
            ds.append(')');
            helper(ans, ds, open, close + 1, n);
            ds.deleteCharAt(ds.length() - 1);
        }
    }
}
