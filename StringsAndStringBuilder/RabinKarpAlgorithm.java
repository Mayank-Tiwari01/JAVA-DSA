package StringsAndStringBuilder;
import java.awt.*;
import java.util.*;
import java.util.Scanner;
// watch : https://www.youtube.com/watch?v=gNDIOqdAJiw&t=137s
public class RabinKarpAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt(); //change the variables later when you understand what they do.
        while (t-- > 0) {
            solve();
        }
    }

    public static void solve() {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next(); // desired value which we want to search

        long prime = 31;
        long mod = 1000000007;
        long desiredHashValue = s2.charAt(0) - 'a' + 1;
        long pow = prime;

        //Desired hash value of the substring we want to search (s2)

        for (int i = 1; i < s2.length(); i++) {
            desiredHashValue += ((s2.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * prime) % mod;
        }

        long[] prefixHashArr = new long[s1.length()];
        long[] powerArr = new long[s1.length()];

        prefixHashArr[0] = s1.charAt(0) - 'a' + 1;
        powerArr[0] = 1;
        //leaving at 40:00 kyuki sir ke uppar se ja raha.

    }

}
