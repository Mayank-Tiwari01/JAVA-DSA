package CSESIntroductoryProblems;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dna = in.next();
        System.out.println(maxSubSeq(dna));
    }
    static int maxSubSeq(String dna) {
        int count = 1;
        int temp = 1;
        int i = 0;
        int j = 1;
        while (j < dna.length()) {
            if (j < dna.length() && dna.charAt(i) == dna.charAt(j)) {
                temp++;
                i++;
                j++;
                count = Math.max(count, temp);
            }
            else if ( j < dna.length() && dna.charAt(i) != dna.charAt(j)) {
                count = Math.max(count, temp);
                temp = 1;
                i++;
                j++;
            }
        }
        return count;
    }
}
