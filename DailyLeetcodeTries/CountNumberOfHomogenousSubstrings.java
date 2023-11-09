package DailyLeetcodeTries;
/*
Runtime
13ms
Beats 17.20%of users with Java

I have pasted the edited version of my code which chatgpt wrote, it is much better and follows the same logic
9ms
Beats 80.00%of users with Java
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
            if (s.charAt(firstPointer) == s.charAt(secondPointer)) {
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
    static long sumOfNums(long length) {
        return (length * (length + 1) / 2) - length;
    }
}
/*

These changes should make your code more concise and avoid unnecessary checks and floating-point arithmetic.
Overall, your code is functional and provides a good solution to the problem.

Class Solution {
    public int countHomogenous(String s) {
        int length = s.length();
        long ans = length;
        long mod = (long) Math.pow(10, 9) + 7;
        int firstPointer = 0;
        int secondPointer = 1;

        while (secondPointer < length) {
            if (s.charAt(firstPointer) == s.charAt(secondPointer)) {
                secondPointer++;
            } else {
                if (secondPointer - firstPointer >= 2) {
                    ans = (ans + sumOfNums(secondPointer - firstPointer)) % mod;
                }
                firstPointer = secondPointer;
                secondPointer++;
            }
        }
        ans = (ans + sumOfNums(secondPointer - firstPointer)) % mod;
        return (int) ans;
    }

    static long sumOfNums(long length) {
        return (length * (length + 1) / 2) - length;
    }
}

 */