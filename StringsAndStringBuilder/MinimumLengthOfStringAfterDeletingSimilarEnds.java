package StringsAndStringBuilder;
// I myself made the code pretty complex, just manually increment and decrement the pointers.
//see my code below.
public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String s = "aaabbbbaaaa";
    }
    static int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);
            while (l <= r && s.charAt(l) == ch) l++;
            while (l <= r && s.charAt(r) == ch) r--;
        }
        return r - l + 1;
    }
}
/*
while (start <= end) {
            char temp = s.charAt(start);
            if (s.charAt(start) == temp && s.charAt(end) == temp) {
                while ((start <= end) && (s.charAt(start) == temp || s.charAt(end) == temp)) {
                    start = (s.charAt(start) == temp) ? start + 1 : start;
                    end = (s.charAt(end) == temp) ? end - 1 : end;
                }
                temp = s.charAt(start);
            }
            //early exit
            if (s.charAt(end) != temp || start == end)
                break;
        }
        return (end < start) ? 0 : end - start + 1;
 */