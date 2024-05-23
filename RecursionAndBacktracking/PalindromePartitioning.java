package RecursionAndBacktracking;
import java.util.*;
public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aadsd";
        System.out.println(partition(s));
    }
    static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        findPartition(s, 0, ans, ds);
        return ans;
    }
    static void findPartition(String s, int idx, List<List<String>> ans, List<String> ds) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        //idx will be the start of the substring and i will be the end.
        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                ds.add(s.substring(idx, i + 1));
                findPartition(s, i + 1, ans, ds);
                ds.remove(ds.size() - 1);
            }
        }
    }
    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}