package ArrayQuestions;
import java.util.Arrays;
import java.util.*;


public class TargetUsingList {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        int[] ans = new int[nums.length];

        ArrayList <Integer> ansList = new ArrayList <> ();

        for(int i = 0; i < nums.length; i++){
            ansList.add(index[i], nums[i]);   
        }

        for(int i = 0; i < ansList.size(); i++){
            ans[i] = ansList.get(i);
        }

        System.out.println(Arrays.toString(ans));
    }
}
