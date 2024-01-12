package StringsAndStringBuilder;

public class DetermineIfStringHalveAreAlike {
    public static void main(String[] args) {
        String s = "book";
        System.out.println(isAlike(s));
    }
    static boolean isAlike(String s) {
        int len = s.length();
        int half = (len / 2) - 1;
        int count = 0;
        for (int i = 0; i < len; i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                if (i <= half) count++;
                else count --;
            }
        }
        return (count == 0);
    }
}