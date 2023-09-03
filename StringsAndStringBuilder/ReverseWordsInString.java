package StringsAndStringBuilder;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "It is a sunny day with sunlight and clouds";
        System.out.println(reverseWords(s));
    }
    static String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }

        int i = s.length() - 1;
        String ans = "";
        while ( i > 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;

            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (ans.isEmpty()) {
                ans = ans.concat(s.substring(i + 1, j + 1));
            }
            else {
                ans = ans.concat(' ' + s.substring(i + 1, j + 1));
            }
        }
        return  ans;
    }
}

/*
gfg
if (s.length() == 1) {
            return s;
        }

        int i = s.length() - 1;
        String ans = "";
        while ( i > 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;

            if (i < 0) break;

            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }

            if (ans.isEmpty()) {
                ans = ans.concat(s.substring(i + 1, j + 1));
            }
            else {
                ans = ans.concat(' ' + s.substring(i + 1, j + 1));
            }
        }
        return  ans;
    }
}

 */
