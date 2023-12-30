package StringsAndStringBuilder;
/*
was very easy but please take care when the pat is > than str and when searching for first char in str, make sure the
remaining chars in the string are more than or equal to the number of chars in pat.
what I mean by that is, make sure that if you find the first char to be matching in str, then before creating a substring
check if you even can, check if the char is on the last and chars coming after it are less than what we need.
 */
class FindTheIndexOfTheFirstOccurrenceInString {
    public static void main(String[] args) {
        String str = "amafihafiafabfabfbaz";
        String pat = "azx";
        System.out.println(strStr(str, pat));
    }
    static int strStr(String str, String pat) {
        int strLen = str.length(), patLen = pat.length();

        if (patLen > strLen) return -1;

        if (patLen == 1) {
            for (int i = 0; i < strLen; i++) {
                if (str.charAt(i) == pat.charAt(0)) {
                    return i;
                }
            }
        }
        else {
            for (int j = 0; j <= strLen - patLen; j++) {
                if (str.charAt(j) == pat.charAt(0)) { // && (strLen - j + 1) > (patLen)
                    String strSub = str.substring(j, j + patLen);
                    if (isEqual(strSub, pat, patLen)) return j;
                }
            }
        }
        return -1;
    }
    static boolean isEqual(String str, String pat, int length) {
        int pointer = 0;

        while (pointer < length) {
            if (str.charAt(pointer) != pat.charAt(pointer)) {
                return false;
            }
            else pointer++;
        }
        return true;
    }
}
/*
class Solution {
    public int strStr(String str, String pat) {
        if (pat.length() == 1) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == pat.charAt(0)) {
                   return i;
                }
            }
        }
        else {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == pat.charAt(0)) {
                    if (str.regionMatches(j, pat, 0, pat.length())) {
                        return j;
                    }
                }
            }
        }
        return -1;
    }
}
 */