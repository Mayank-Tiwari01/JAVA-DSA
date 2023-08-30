package StringsAndStringBuilder;
//0p?
public class Palindrome {
    public static void main(String[] args) {
        String sentence = "race a car"; //false
        String palindromeSentence = "A man, a plan, a canal: Panama"; //true
        System.out.println(isPalindrome(sentence)); //false
        System.out.println(isPalindrome(palindromeSentence)); //true
    }
    static boolean isPalindrome(String s) {
//        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int startPointer = 0;
        int endPointer = s.length() - 1;

        while (startPointer < endPointer) {
            if (s.charAt(startPointer) != s.charAt(endPointer)) {
                return false;
            }
            startPointer++;
            endPointer--;
        }
        return true;
    }
}
