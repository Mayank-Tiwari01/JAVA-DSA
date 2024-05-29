package RecursionAndBacktracking;
import java.util.*;
public class WordBreakII {

    static  List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        solve(s, set, new StringBuilder(), ans, 0);
        return ans;
    }

    static void solve(String s, HashSet<String> set, StringBuilder str, List<String> ans, int start) {
        if (start == s.length()) {
            ans.add(str.toString());
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (set.contains(sub)) {
                int len = str.length();
                if (len != 0) str.append(" ");
                str.append(sub);
                solve(s, set, str, ans, end + 1);
                str.setLength(len); // Backtrack to previous state
            }
        }

    }
}

