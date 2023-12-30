package StringsAndStringBuilder;
//23 ms, 73%. Basically checking every substring length that divides the string length.
public class RepeatedSubstringPatternProperWay {
    public static void main(String[] args) {
        String s = "abaabaaba";
        System.out.println(repeatedSubstringPattern(s));
    }
    static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 0; i--) {
            if (len % i == 0) {
                int repetitions = len / i;
                StringBuilder repeatedString = new StringBuilder();
                String temp = s.substring(0, i);
                while (repetitions > 0) {
                    repeatedString.append(temp);
                    repetitions--;
                }
                if (repeatedString.toString().equals(s)) return true;
                /*
                 if (len % i == 0) {
                int repetitions = len / i;
                String repeatedString = s.substring(0, i).repeat(repetitions);
                if (repeatedString.equals(s)) {
                    return true;
                }
            }
                 */
            }
        }
        return false;
    }
}
