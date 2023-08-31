package StringsAndStringBuilder;

public class PrintFrequencyOfstringInAlphabeticalOrder {
    public static void main(String[] args) {
        String sentence = "geeksforgeeks";
        int[] count = new int[26];

        for (int i = 0; i < sentence.length(); i++) {
            count[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                int c = i + 'a';
                System.out.println((char) c + " " + count[i]);
            }
        }
    }
}
