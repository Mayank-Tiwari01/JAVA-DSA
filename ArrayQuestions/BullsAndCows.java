package ArrayQuestions;
//class
public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(numOfBullsCows(secret, guess));
    }
    static String numOfBullsCows(String secret, String guess) {
        int[] freqMap = new int[10];
        int len = secret.length();


        int bulls = 0, cows = 0;
        for (int i = 0; i < len; i++) {
            char c = secret.charAt(i);
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
//            else map[Character.getNumericValue(c)]++;
            else freqMap[secret.charAt(i )- '0']++;
        }


        for (int i = 0; i < len; i++) {
            char c = guess.charAt(i);
            if (secret.charAt(i) != guess.charAt(i)) {
                if (freqMap[Character.getNumericValue(c)] > 0) {
                    freqMap[Character.getNumericValue(c)]--;
                    cows++;
                }
            }
        }
        return String.valueOf((bulls) + "A" + (cows) + "B");
    }
}
