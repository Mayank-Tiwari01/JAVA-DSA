package StringsAndStringBuilder;

public class LeftmostRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcdefgg";
        System.out.println(repeatingChar(s));
    }
    static int repeatingChar(String s) {
        //static char repeatingChar(String s) // if asked for char.
        int[] charArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            charArr[index]++;
        }

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (charArr[index] >= 2) {
                return i;
                //return s.charAt(i); //if asked for char
            }
        }
        return -1; //return '#' if asked for char.
    }
}
