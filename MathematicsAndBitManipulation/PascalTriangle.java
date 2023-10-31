package MathematicsAndBitManipulation;
import java.util.*;
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 10;
        System.out.println(generate(numRows));
    }
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        long ans = 1;
        for (int i = 1; i <= numRows; i++) {
            List<Integer>temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                ans *= (i - j);
                ans/= j;
                temp.add((int)ans);
            }
            pascalTriangle.add(temp);
        }
        return pascalTriangle;
    }
}
