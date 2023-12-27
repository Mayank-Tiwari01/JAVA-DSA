package StringsAndStringBuilder;

public class SubstringsofSizeThreewithDistinctCharacters {
    public static void main(String[] args) {
        String s = "abcsjfasjbcdhfjkhsdcbcsbcb";
        System.out.println(goodSubArr(s));
    }
    static int goodSubArr(String s) {
        int counter = 0;
        int len =  s.length();
        if (len < 3) return 0;
        for (int i = 0; i < len - 2; i++) {
            if (s.charAt(i) != s.charAt(i+1) && s.charAt(i+1) != s.charAt(i + 2) && s.charAt(i) != s.charAt(i+2)) counter++;
        }
        return counter++;
    }
}
