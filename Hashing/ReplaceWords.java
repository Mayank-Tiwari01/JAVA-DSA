package Hashing;
import java.util.*;

public class ReplaceWords {
    static String replaceWordsGPT(List<String> dictionary, String sentence) {
        Set<String> roots = new HashSet<>(dictionary);

        // Step 2: Split the sentence into individual words.
        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            // Initialize a variable to keep track of the replacement root.
            String replacement = null;

            // Check each prefix of the word to see if it's in the roots set.
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (roots.contains(prefix)) {
                    replacement = prefix;
                    break;
                }
            }

            // If a replacement was found, add it to the result.
            // Otherwise, add the original word.
            if (replacement != null) {
                result.append(replacement);
            } else {
                result.append(word);
            }

            result.append(" ");
        }

        return result.toString().trim();
    }
    static String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>(dictionary);

        StringBuilder str = new StringBuilder();

        int start = 0, end = 0;

        while (end < sentence.length()) {
            if (sentence.charAt(end) == ' ' || end == sentence.length() - 1) {
                str.append(sentence, start, end + 1);
                end++;
                start = end;
            }
            else if (set.contains(sentence.substring(start, end + 1))) {
                str.append(sentence, start, end + 1);
                str.append(' ');

                while (end < sentence.length() && sentence.charAt(end) != ' ')
                    end++;
                end++;
                start = end;
            }
            else
                end++;

        }
        return str.toString().trim();
    }
}
