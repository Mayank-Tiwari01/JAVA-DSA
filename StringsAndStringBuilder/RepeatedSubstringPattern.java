package StringsAndStringBuilder;
/*
won't say i understand the logic completely.
 */
public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(isSubstringRepeating(s));
    }
    static boolean isSubstringRepeating(String s) {
        String a1=s+s;
        String a2=a1.substring(1,a1.length()-1);
        return a2.contains(s);
    }
}
/*
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] charArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charArray[index]++;
        }

        int constant = 0;
        int x = 0;
        int flag = 1;

        for (int j = 0; j < charArray.length; j++) {
            if (charArray[j] != 0) {
                constant = charArray[j];
                x = j;
                break;
            }
        }

        for (int k = x; k < charArray.length; k++) {
            if (charArray[k] != 0 && constant != charArray[k]) {
               flag = -1;
            }
        }
        return flag == 1;
    }
}

 */

/*
    static boolean isSupstringRepeating(String s) {
        int[] charArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charArray[index]++;
        }

        int flag = 1;

        for (int k = 0; k < charArray.length; k++) {
            if (charArray[k] != 0 && charArray[k] % 2 != 0) {
               flag = -1;
            }
        }
        return flag == 1;
    }
 */