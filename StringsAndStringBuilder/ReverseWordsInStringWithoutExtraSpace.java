package StringsAndStringBuilder;

public class ReverseWordsInStringWithoutExtraSpace {
    public static void main(String[] args) {
        String s = "     It is a sunny day   with sunlight and   clouds         ";
        System.out.println(reverseWordsInString(s));
    }
    static String reverseWordsInString(String s) {
        int i = 0;
        char[] charArray = s.toCharArray();

        while (i < charArray.length) {

            while (i < charArray.length && charArray[i] == ' ') {
                i++;
            }
            int j = i;

            while (i < charArray.length && charArray[i] != ' ') {
                i++;
            }
            reverseWords(charArray, j, i - 1);
        }
        String ans = "";
        for (int j = charArray.length - 1; j >= 0; j--) {
            if (charArray[j] != ' ') {
                ans += charArray[j];
            }
        }
        return ans;
    }

    static void reverseWords(char[] charArray, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            char temp = charArray[startIndex];
            charArray[startIndex] = charArray[endIndex];
            charArray[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
