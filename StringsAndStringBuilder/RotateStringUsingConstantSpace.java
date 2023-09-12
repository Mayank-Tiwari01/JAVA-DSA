package StringsAndStringBuilder;
/*
original approach but works only when the characters are unique :/
maybe I can modify the code to work, but I am sleepy, and it is 2:20 AM.
 */
public class RotateStringUsingConstantSpace {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(isRotate(s, goal));
    }
    static boolean isRotate(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int firstCharIndex = 0;
        for (int i = 0; i < goal.length(); i++) {
            if (s.charAt(0) == goal.charAt(i)) {
                firstCharIndex = i;
            }
        }

        if (goal.substring(firstCharIndex).equals(s.substring(0, s.length() - firstCharIndex))
        && goal.substring(0, firstCharIndex).equals(s.substring(s.length() - firstCharIndex))) {
            return true;
        }
        return false;
    }
}
