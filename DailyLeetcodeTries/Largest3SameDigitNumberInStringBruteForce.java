package DailyLeetcodeTries;
//Again a very low effort code. Ludhiāna shopping day.
public class Largest3SameDigitNumberInStringBruteForce {
    public static void main(String[] args) {
        String nums = "2300019";
        System.out.println(sameDigitSubstring(nums));
    }
    static String sameDigitSubstring(String nums) {
        int len = nums.length();
        int ans = -1;
       for (int i = 0; i < len - 2; i++) {
           if (nums.charAt(i) == nums.charAt(i + 1) && nums.charAt(i + 1) == nums.charAt(i + 2)) {
               int j = nums.charAt(i) - '0';
//               int j = Character.getNumericValue(nums.charAt(i)); (Alternate way)
               if (ans < j) {
                   ans = j;
               }
           }
       }
       if (ans >= 0) {
           return "" + ans + ans + ans;
       }
       return "";
    }
}
