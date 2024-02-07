package BasicJavaPrograms;
import java.io.*;
import java.io.BufferedReader;
public class bufferReader {
    public static void main(String[] args) throws Exception {
        // BufferedReader to read input from STDIN
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading Bob's likes and dislikes
        String bobLikesDislikes = br.readLine();

        // Reading Alice's likes and dislikes
        String aliceLikesDislikes = br.readLine();

        // Closing the BufferedReader as it's no longer needed
        br.close();

        // Counting the number of topics both Bob and Alice like or dislike
        int count = countMatchingTopics(bobLikesDislikes, aliceLikesDislikes);

        // Printing the result
        System.out.println(count);
    }

    // Function to count the number of topics both like or dislike
    private static int countMatchingTopics(String bob, String alice) {
        int count = 0;

        // Assuming both input strings are of the same length
        int length = bob.length();

        // Iterating through each character and checking if they match
        for (int i = 0; i < length; i++) {
            if (bob.charAt(i) == alice.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}