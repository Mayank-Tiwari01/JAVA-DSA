package StringsAndStringBuilder;
/*
Runtime
21ms
Beats 87.62%of users with Java
Memory
44.36MB
Beats 96.03%of users with Java
 */
import java.util.ArrayList;

public class SortVowelsInAString {
    public static void main(String[] args) {
        String s = "lEeeetcOOdeeeuU"; // ans = "lEOOUtceedeeeeu"
        System.out.println(sortVowels(s));
    }
    static String sortVowels(String s) {
        StringBuilder t = new StringBuilder(s.length());
        int[] chars = new int[53];
        ArrayList<Integer> mapVowels = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a'|| s.charAt(i) == 'e'|| s.charAt(i) == 'i'|| s.charAt(i) == 'o'||s.charAt(i) == 'u'|| s.charAt(i) == 'A'||s.charAt(i) == 'E'||s.charAt(i) == 'I'||s.charAt(i) == 'O'||s.charAt(i) == 'U') {
                t.append(1); //we will add vowels according to their ascii value later.
                mapVowels.add(i);
                int index = s.charAt(i) - 'A';
                chars[index]++;
            }
            else {
                t.insert(i, s.charAt(i));
            }
        }
        for (int i = 0; i < chars.length; i++) {
            int j = 0;
            if (chars[i] != 0) {
                while(chars[i] != 0) {
                    int c = i + 'A';
                    int index = mapVowels.get(j);
                    t.setCharAt(index , (char) c);
                    j++;
                    chars[i]--;
                }
            }
        }
        return t.toString();
    }
}
