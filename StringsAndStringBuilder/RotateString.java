package StringsAndStringBuilder;
/*
Overall, your code efficiently checks if one string is a rotation of another string by using the property of rotation,
where a rotation of a string can be found within the concatenated original string.
 */
public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(isRotateString(s, goal));
    }
    static boolean isRotateString(String s, String goal) {
        String example = s + s;
        return s.length() == goal.length() && example.contains(goal);
    }
}
