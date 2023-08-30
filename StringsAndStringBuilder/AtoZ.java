package StringsAndStringBuilder;

/*
String concatenation in += loop. Using String Builder would be much efficient.
O(n^2)
 */

public class AtoZ {
    public static void main(String[] args) {
        String alphabets = "";

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            alphabets += ch;
            alphabets += " ";
        }

        System.out.println(alphabets);
    }
}

