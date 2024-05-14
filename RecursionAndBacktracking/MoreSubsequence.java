package RecursionAndBacktracking;
import java.util.*;
//brute force solution and optimal both, brute force is not even a solution, I think.
//https://www.codingninjas.com/studio/problems/more-subsequence_8842355?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
public class MoreSubsequence {
    public static void main(String[] args) {
        String a = "fix";
        String b = "eegg";
        System.out.println(moreSubsequence(a, b));
    }
    static String moreSubsequence(int n, int m, String a, String b) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (int i = 0; i < a.length(); i++) {
            set1.add(a.charAt(i));
        }
        for (int i = 0; i < b.length(); i++) {
            set2.add(b.charAt(i));
        }

        if(set1.size() > set2.size()) return a;
        return (a.length() >= b.length()) ? a : b;
    }

    static String moreSubsequence(String a, String b) {
        char[] aCharArr = a.toCharArray();
        Arrays.sort(aCharArr);
        String sortedA = new String(aCharArr);
        aCharArr = b.toCharArray();
        Arrays.sort(aCharArr);
        String sortedB = new String(aCharArr);

        List<String> subA = new ArrayList<>();
        List<String> subB = new ArrayList<>();

        distinctSub(a, 0, subA, new StringBuilder());
        distinctSub(b, 0, subB, new StringBuilder());

        System.out.println(subA);
        System.out.println(subB);
        return (subA.size() >= subB.size()) ? a : b;
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