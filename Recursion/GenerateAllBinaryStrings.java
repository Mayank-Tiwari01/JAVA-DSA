package Recursion;
import java.util.*;
public class GenerateAllBinaryStrings {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateString(n));
    }
    static List< String > generateString(int N) {
        List<String> ans = new ArrayList<>();
        StringBuilder binStr = new StringBuilder();
        helper(ans, binStr, N, 0);
        return ans;
    }
    static void helper(List<String> ans, StringBuilder binStr, int n, int idx) {
        if (idx == n) {
            ans.add(binStr.toString());
            return;
        }

        binStr.append('0');
        helper(ans, binStr, n, idx + 1);
        binStr.deleteCharAt(idx);

        if (idx == 0 || binStr.charAt(idx - 1) != '1') {
            binStr.append('1');
            helper(ans, binStr, n, idx + 1);
            binStr.deleteCharAt(idx);
        }
    }
}
