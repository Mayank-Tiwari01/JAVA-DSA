package StringsAndStringBuilder;

public class ReverseWordsInStringComplicated {
    public static void main(String[] args) {
        String s = "    It is a sunny day   with sunlight and   clouds         ";
        System.out.println(reverseWordsInString(s));
    }
    static String reverseWordsInString(String s) {
        int i = 0;
        char[] charArray = s.toCharArray();
        String ans = "";

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

        int numOfSpace = 0;
        for (int j = charArray.length - 1; j >= 0; j--) {

            if (charArray[j] != ' ') {
                ans += charArray[j];
            }
            if (charArray[j] == ' ') {
                int pointer = j;
                while ( pointer >= 0 && charArray[pointer] == ' ') {
                    pointer--;
                }
                ans += ' ';
                j = pointer + 1;
                }
            }
        ans = ans.trim();
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
