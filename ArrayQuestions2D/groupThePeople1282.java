package ArrayQuestions2D;
// do it when you know hashing. Bade aye.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class groupThePeople1282 {
    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        System.out.println(groupingThePeople(groupSizes));
    }
    static ArrayList<ArrayList<Integer>> groupingThePeople(int[] groupSizes) {
        ArrayList<ArrayList<Integer>> groupedPeople = new ArrayList<>();
        Arrays.sort(groupSizes);
        Set<Integer> uniqueSet = new HashSet<>();
        for (int groupSize : groupSizes) {
            uniqueSet.add(groupSize);
        }

        return groupedPeople;
    }
}
