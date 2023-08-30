package StringsAndStringBuilder;
/*
much better cause String Builder creates only one object, and it keeps on adding strings to that object
thus it is more memory efficient and faster too. Also, the reference variable remains same.
O(n).
 */
public class AtoZUsingStringBuilder {
    public static void main(String[] args) {
        StringBuilder alphabets = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            alphabets.append(ch).append(" ");
        }
        System.out.println(alphabets.toString());
    }
}
