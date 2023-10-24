package Mathematics;
import java.util.*;
public class pascalII {
    public static void main(String[] args) {
        int rowIndex = 5;
        System.out.println(getRow(rowIndex ));
    }
    static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        rowIndex++; //for leetcode :/
        long ans = 1;
        row.add(1);
        for (int i = 1; i < rowIndex ; i++) {
            ans *= (rowIndex - i);
            ans /= i;
            row.add((int)ans);
        }
        return row;
    }
}
// an optimal result. 0 ms runtime.