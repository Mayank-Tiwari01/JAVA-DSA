package DailyLeetcodeTries;

public class ReverseWordsString {
    public static void main(String[] args) {
        String s = "  gojo satoru my             OP   OG        herooooooo      ";
        System.out.println(reversedWord(s));
    }
    static String reversedWord(String s) {
        StringBuilder reverse = new StringBuilder();
        int len = s.length(), wordStart = len - 1, wordEnd = len - 1;

        if (len == 1) return s;

        while (wordStart > 0) {
            if (s.charAt(wordStart) == ' ' && s.charAt(wordEnd) == ' ') {
                wordStart--;
                wordEnd--;
            }
            if (s.charAt(wordStart) != ' ' && s.charAt(wordEnd) != ' ') {
                while (s.charAt(wordStart) != ' ' || wordStart == 0){
                    if(wordStart == 0) break;
                    else wordStart--;
                }
                if (wordStart == 0 && s.charAt(wordStart) != ' ')  reverse.append(s, (wordStart), (wordEnd + 1));
                else reverse.append(s, (wordStart + 1), (wordEnd + 1));
                //reverse.append((first == 0) ? s.substring(first, last + 1) : s.substring(first + 1, last + 1));
                reverse.append(' ');
                wordEnd = wordStart;
            }
        }
        return reverse.toString().trim();
    }

}


