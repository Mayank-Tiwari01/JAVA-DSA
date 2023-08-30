package StringsAndStringBuilder;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'z','y','x','l','o','m'};
        System.out.println(Arrays.toString(reverse(s)));
    }
    static char[] reverse (char[] s) {
        int start = 0;
        int end = s.length - 1;

        while ( start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start ++;
            end --;
        }
        return s;
    }
}
