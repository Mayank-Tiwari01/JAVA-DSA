package MathematicsAndBitManipulation;
import java.util.*;
public class NumberOfLaserBeamsInBank {
    public static void main(String[] args) {
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }
    static int numberOfBeams(String[] bank) {
        int secDevices = 0, totalBeams = 0, securedFloors = 0;
        ArrayList<Integer> totalDevices = new ArrayList<>();

        for (String floor : bank) {
            for (int i = 0; i < floor.length(); i++) {
                if (floor.charAt(i) == '1') secDevices++;
            }
            if (secDevices != 0){
                totalDevices.add(secDevices);
                secDevices = 0;
                securedFloors++;
            }
        }

        for (int i = 0; i < securedFloors - 1; i++) {
            totalBeams += totalDevices.get(i) * totalDevices.get(i + 1);
        }
        return totalBeams;
    }
}


