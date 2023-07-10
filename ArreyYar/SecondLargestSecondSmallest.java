package ArreyYar;
import java.util.Arrays;

public class SecondLargestSecondSmallest {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] ans = new int[2];
        int n = a.length;
        Arrays.sort(a);

        ans[0] = a[n-2];
        ans[1] = a[n-n+1];

        System.out.println(Arrays.toString(ans));




    }
}
