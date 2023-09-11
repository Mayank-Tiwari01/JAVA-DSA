package StringsAndStringBuilder;
//this should be marked hard /s
public class LargestOddNumberString {
    public static void main(String[] args) {
        String s = "2225222222";
        System.out.println(largestOdd(s));
    }
    static String largestOdd(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (num.charAt(i) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
