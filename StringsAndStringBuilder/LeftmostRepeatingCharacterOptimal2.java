package StringsAndStringBuilder;

public class LeftmostRepeatingCharacterOptimal2 {
    public static void main(String[] args) {
        String s = "aabcdefgg";
        System.out.println(repeatingChar(s));
    }
    static int repeatingChar(String s) {
        int result = -1;
        boolean[] booleanArr = new boolean[26];
        //s consists of only lowercase English letters.

        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            if (!booleanArr[index]) {
                booleanArr[index] = true;
            }

            else {
                result = index;
            }
        }
        return result;
    }
}
