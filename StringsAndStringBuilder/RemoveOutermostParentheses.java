package StringsAndStringBuilder;
// logic is not mine. but i don't think i would have come up with it anyway.
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(findingPrimitiveString(s));
    }

    static String findingPrimitiveString(String s) {
        int count = 0;
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count != 0) {
                    result.append(c);
                }
                count++;
            } else {
                if (count != 1) {
                    result.append(c);
                }
                count--;
            }
        }

        return result.toString();
    }
}
