package StringsAndStringBuilder;
/*
Runtime
9ms
Beats 10.66%of users with Java
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"docxg","d","docxarulhg", "docxascxa"};
        System.out.println(longestPrefix(strs));
    }
    static String longestPrefix(String[] strs) {
        int compare = 0;
        String prefix = "";

        //handling the edge case for an empty string and finding the shortest string.
        int nonEmptyStr = Integer.MAX_VALUE;
        int shortestStr = 0;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() == 0) {
                return "";
            }
            if (strs[i].length() < nonEmptyStr && strs[i].length() != 0) {
                nonEmptyStr = strs[i].length();
                shortestStr = i;
            }
        }

        //loop which compares the shortest string characters to every other character.
        for (int i = 0; i < strs[shortestStr].length(); i++) {
            boolean isSame = true;
            for (int j = 1; j < strs.length; j++) {
                // if something is different, we do not need to go any further.
                 if (compare < strs[j].length() && strs[0].charAt(i) != strs[j].charAt(compare)) {
                    isSame = false;
                    break;
                }
            }
            compare++;
            // add only if that char is present in all the strings.
            if (isSame) {
                prefix += strs[0].charAt(i);
            }
            // else you can break out it.
            else {
                break;
            }
        }
        return prefix;
    }
}
