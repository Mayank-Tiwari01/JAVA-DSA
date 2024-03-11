package StringsAndStringBuilder;

public class CustomSortString {
    public static void main(String[] args) {
        String s = "fsjhsdfjh";
        String order = "efhsd";
    }
    static String customSortString(String order, String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (char c : order.toCharArray()) {
            while (charCount[c - 'a'] > 0) {
                ans.append(c);
                charCount[c - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');
            while (charCount[i] > 0) {
                ans.append(c);
                charCount[i]--;
            }
        }
        return ans.toString();
    }
}
