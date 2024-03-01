package MathematicsAndBitManipulation;

public class MaximumOddBinaryNumber {
    public static void main(String[] args) {
        String s = "01101";
        System.out.println(maximumOddBinaryNumber(s));
    }
    static String maximumOddBinaryNumber(String s) {
        int oneCount = 0;
        for(char c : s.toCharArray()) {
            if (c == '1')
                oneCount++;
        }
        int saveCount = oneCount;
        StringBuilder ans = new StringBuilder();
        while (oneCount > 1) {
            ans.append('1');
            oneCount--;
        }
        int rem = s.length() - saveCount;
        while (rem > 0) {
            ans.append('0');
            rem--;
        }
        ans.append('1');
        return ans.toString();
    }
}
