package StringsAndStringBuilder;

public class FindTheDifference {
    public static void main(String[] args) {
        String s = "e";
        String t = "xe";
        System.out.println(addedChar(s, t));
    }
    static char addedChar (String s, String t) {
        int[] charArray = new int[26];

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            charArray[index]++;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a' ;
            charArray[index]--;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (charArray[index] != 0) {
                return t.charAt(i);
            }
        }
        return '#';
    }
}
