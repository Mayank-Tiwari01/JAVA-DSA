package MathematicsAndBitManipulation;
/*
Everything OG ofc. The only medium thing about this question is how it's framed lol.
 */
public class NumberOfLaserBeamsInBankConstSpace {
    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }
    static int numberOfBeams(String[] bank) {
        int secDevices = 0, totalBeams = 0;
        int prev = 0;

        for (String floor : bank) {
            for (int i = 0; i < floor.length(); i++) {
                if (floor.charAt(i) == '1') secDevices++;
            }
            if (secDevices != 0){
                totalBeams += prev * secDevices;
                prev = secDevices;
                secDevices = 0;
            }
        }
        return totalBeams;
    }
}


