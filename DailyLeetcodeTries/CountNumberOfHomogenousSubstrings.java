package DailyLeetcodeTries;
/*
Runtime
15ms
Beats 13.20%of users with Java
 */
public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        String s = "abbcccaa";
        System.out.println(numHomoString(s));
    }
    static int numHomoString(String s) {
        int length = s.length();
        double ans = length;
        double mod = Math.pow(10, 9) + 7;
        int firstPointer = 0;
        int secondPointer = 1;

        while (secondPointer < length) {
            if (secondPointer < length && s.charAt(firstPointer) == s.charAt(secondPointer)) {
                secondPointer++;
            }
            if (secondPointer < length && s.charAt(firstPointer) != s.charAt(secondPointer)) {
                if (secondPointer - firstPointer >= 2) {
                    ans += sumOfNums(secondPointer - firstPointer);
                }
                firstPointer = secondPointer;
                secondPointer++;
            }
            if (secondPointer == length) {
                ans += sumOfNums(secondPointer - firstPointer);
            }
        }
        return (int) (ans % mod);
    }
    static double sumOfNums(double length) {
        return (length * (length + 1)) / 2 - (length);
    }
}
