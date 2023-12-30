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
                int subArrays = len / i;
                StringBuilder subStringAdd = new StringBuilder();
                String temp = s.substring(0, i);
                while (subArrays > 0) {
                    subStringAdd.append(temp);
                    subArrays--;
                }
                if (subStringAdd.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
