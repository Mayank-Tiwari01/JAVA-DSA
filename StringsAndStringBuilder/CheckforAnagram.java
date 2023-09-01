package StringsAndStringBuilder;

public class CheckforAnagram {
    public static void main(String[] args) {
        String s1 = "listen";
        String s2 = "silent";

        System.out.println(isAnagram(s1, s2));
    }
    static boolean isAnagram(String s, String t) {
        //s and t consist of lowercase English letters.
        if (s.length() != t.length()) {
            return false;
        }

        int[] tempArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            tempArr[index]++;
            //
            int indexTwo = t.charAt(i) - 'a';
            tempArr[indexTwo]--;
        }

        for (int j = 0; j < 26; j++) {
            if (tempArr[j] != 0) {
                return false;
            }
        }
        return true;
    }
}
