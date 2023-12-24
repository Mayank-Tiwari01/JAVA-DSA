package StringsAndStringBuilder;
/*
runtime = 4ms, beats = 74%.
Everything OG ofc. Took me maybe five minutes to figure out that there can only be two possible ways to make a binary
string alternative, either it starts with zero or with one. But then it took me maybe 10 minutes to write the condition
in a single pass. Which I think is a lot. My original code is written below in the comments, this code was suggested by GPT.
It is the same code, but it is much better. Same complexity, just a better way of calculating things which are required.
 */
public class MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        String s = "101010000011110000";
        System.out.println(minOperations(s));
    }
    static int minOperations(String s) {
        int case1 = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') case1++;
            }
            else {
                if (s.charAt(i) == '0') case1++;
            }
        }
        return Math.min(case1, len - case1);
    }
}
/*
runtime = 8ms, beats 7.54%
class Solution {
    public int minOperations(String s) {
        int minOp = 0;
        int case1 = 0;
        int case2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && i % 2 != 0
            || s.charAt(i) == '1' && i % 2 == 0){
                case1++;
            }
            if (s.charAt(i) == '0' && i % 2 == 0
            || s.charAt(i) == '1' && i % 2 != 0) {
                case2++;
            }
        }
        return Math.min(case1, case2);
    }
}
 */