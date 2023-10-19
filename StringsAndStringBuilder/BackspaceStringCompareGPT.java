package StringsAndStringBuilder;
// chatGPT used the same approach, just wrote it better. I mean, obviously.
public class BackspaceStringCompareGPT {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(isEqual(s, t));
    }

    static boolean isEqual(String s, String t) {
        StringBuilder sFinal = new StringBuilder(s);
        StringBuilder tFinal = new StringBuilder(t);

        processBackspaces(sFinal);
        processBackspaces(tFinal);

        return sFinal.toString().contentEquals(tFinal.toString());
    }

    static void processBackspaces(StringBuilder sb) {
        int i = 0;

        while (i < sb.length()) {
            if (sb.charAt(i) == '#') {
                if (i == 0) {
                    sb.deleteCharAt(i);
                } else {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            }
            else {
                i++;
            }
        }
    }
}
