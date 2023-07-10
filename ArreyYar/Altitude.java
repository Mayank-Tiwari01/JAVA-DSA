package ArreyYar;
import java.util.Arrays;

public class Altitude {
    public static void main(String[] args) {

        int gain[] = {-5,1,5,0,-7};
        int length = gain.length;
        int[] ans = new int[length + 1];
        ans[0] = 0;
        int sum = gain[0];
        ans[1] = sum;

        for (int i = 1; i < length; i++){
            sum = sum + gain[i];
            ans[i+1] = sum;
        }
         System.out.println(Arrays.toString(ans));

        int highest = Integer.MIN_VALUE;

        for (int i = 0; i < length + 1; i++){
            if (ans[i] > highest){
                highest = ans[i];
            }
        }

        System.out.println(highest);
    }
}
