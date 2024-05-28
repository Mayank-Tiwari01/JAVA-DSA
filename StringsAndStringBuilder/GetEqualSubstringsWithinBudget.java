package StringsAndStringBuilder;

public class GetEqualSubstringsWithinBudget {
    static int equalSubstring(String s, String t, int maxCost) {
        int len = s.length(); //the length of both the strings is same.
        int start = 0, cost = 0, maxLen = 0;

        for (int end = 0; end < len; end++) {
            cost += Math.abs(s.charAt(end) - t.charAt(end));
            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(start) - t.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }
}
