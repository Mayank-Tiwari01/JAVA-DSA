package StringsAndStringBuilder;

import java.util.ArrayList;

public class PatternSearchingBruteForce {
    public static void main(String[] args) {
        String str = "jklscwscjklasjjkl";
        String pat = "jkl";
        System.out.println(searchPattern(str, pat));
    }
    static ArrayList<Integer> searchPattern (String str, String pat) {
        ArrayList <Integer> patternIndex = new ArrayList<>();
        int strPointer = 0;
        int patPointer = 0;

        while (strPointer <= str.length() - 1) {
           if (strPointer <= str.length() - 1 && str.charAt(strPointer) == pat.charAt(patPointer)) {
               strPointer++;
               patPointer++;
           }
           if (strPointer <= str.length() - 1 && patPointer == pat.length() - 1 && str.charAt(strPointer) == pat.charAt(patPointer)) {
                patternIndex.add(strPointer - patPointer);
               strPointer++;
               patPointer = 0;
            }
           if (strPointer <= str.length() - 1 && str.charAt(strPointer) != pat.charAt(patPointer)) {
               patPointer = 0;
               if (str.charAt(strPointer) != pat.charAt(patPointer)) {
                   strPointer++;
               }
           }
        }
        return patternIndex;
    }
}
