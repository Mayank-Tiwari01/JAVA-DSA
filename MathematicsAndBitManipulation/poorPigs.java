package MathematicsAndBitManipulation;
/*
https://www.youtube.com/watch?v=YQJLNxveyKg
 */
public class poorPigs {
    public static void main(String[] args) {
        int buckets = 4, minutesToDie = 15, minutesToTest = 15;
        System.out.println(minPigs(buckets, minutesToDie, minutesToTest));
    }
    static int minPigs(int buckets, int minDie, int minTest) {
        int rounds = minTest / minDie + 1;
        int pigs = 0;
        while (Math.pow(rounds, pigs) < buckets) {
            pigs++;
        }
        return pigs;
    }
}
